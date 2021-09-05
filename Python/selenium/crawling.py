from os import write
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup
import time
import csv
import urllib.request
import re

# csv 파일로 저장
file = open('place_yogar.csv', 'w', encoding='utf-8', newline='')
writer = csv.writer(file)
writer.writerow(('placenum', 'placename', 'placeaddress', 'placephone',
                'placeinfo', 'placeintro', 'openhour',  'placeimg'))


# 크롬 웹드라이버 연결
options = webdriver.ChromeOptions()
options.add_experimental_option("excludeSwitches", ["enable-logging"])

driver = webdriver.Chrome(
    options=options, executable_path=r"C:\Users\User\Documents\GitHub\Practice\Python\selenium\chromedriver.exe")
driver.get("https://map.naver.com/v5/search")


# 시간 지연
time.sleep(2)

# 검색입력
elem = driver.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")
elem.send_keys("마포구 요가원")
elem.send_keys(Keys.RETURN)


# 5초 delay
time.sleep(2)


# 처음 화면의 html
html = driver.page_source
soup = BeautifulSoup(html, "html.parser")


driver.switch_to.frame('searchIframe')

time.sleep(2)
pages_num = driver.find_elements_by_css_selector(
    '.place_didmount ._2ky45 ._2tk2s')

# list li의 idx값
i = 0

# csv 파일로 저장할 row를 저장하기 위한 list
placeLists = []

# 5페이지까지의 데이터를 추출
for page in pages_num:

    try:
        page.click()

        # 페이징내에서의 리스트 idx값
        list_idx = 0

        # 한 페이지의 place 리스트 무한 반복하여 클릭
        # for v in range(10):
        while(True):
            place_list = []
            time.sleep(3)
            # searchiframe으로 전환
            driver.switch_to.default_content()
            driver.switch_to.frame('searchIframe')

            # 페이징내에서의 리스트 idx값
            list_idx += 1

            # 한 페이지에 클릭할 place가 없을 경우 break를 하기 위한 체크 값
            try:
                time.sleep(1)
                list_ldx_chk = bool(driver.find_element_by_css_selector(
                    '#_pcmap_list_scroll_container ul li:nth-child(' + str(list_idx) + ')'))
                # print('list 여부 : ' + str(list_ldx_chk))

                # 클락할 place 리스트가 있을 경우
                if list_ldx_chk:

                    # 광고 list 제외하기 위한 체크 값
                    advertis_chk = bool(driver.find_elements_by_css_selector(
                        '#_pcmap_list_scroll_container ul li:not(._293u6):nth-child(' + str(list_idx) + ')'))

                    # 광고 list에 붙는 class명이 없을 경우(광고가 아닐 경우)
                    if advertis_chk:

                        # print('광고가 아닌지 여부 : ' + str(advertis_chk))

                        # list li의 idx값 1씩 증가
                        # 광고일 경우엔 증가 x
                        i += 1
                        # print(
                        #    '=================================================================')
                        print('===============================' +
                              str(i) + '번 =============================')

                        # place list 클릭해서 detailpage open
                        content = driver.find_element_by_css_selector(
                            '#_pcmap_list_scroll_container ul li:nth-child(' + str(list_idx) + ') ._3ZU00 ._3LMxZ:first-child')
                        content.click()
                        time.sleep(2)

                        # place 이름 클릭하면 detailpage iframe으로 driver html 전환
                        driver.switch_to.default_content()
                        driver.switch_to.frame('entryIframe')

                        # detail page의 html
                        html = driver.page_source
                        soup = BeautifulSoup(html, "html.parser")

                        # ========== place 정보 추출 ==============

                        # place 번호
                        place_list.append(str(i))

                        # place 이름
                        place_name = soup.select_one('#_title ._3XamX').text
                        # print('매장명 : ' + place_name)
                        place_list.append(place_name)

                        # place 위치
                        place_address = soup.select_one(
                            '.place_section_content ._1aj6- ._1h3B_ ._2yqUQ').text
                        # print('주소 : ' + place_address)
                        place_list.append(place_address)

                        # place 전화번호
                        try:
                            place_tel = soup.select_one(
                                '.place_section_content ._3xPmJ ._1h3B_ ._3ZA0S').text
                            # print('전화번호 : ' + place_tel)
                            place_list.append(place_tel)
                        except Exception as e:
                            place_tel = ''
                            # print('전화번호 : ' + place_tel)
                            place_list.append(place_tel)

                        # place 이용정보
                        try:

                            place_info = soup.select_one(
                                '.place_section_content ._6aUG7 ._1M_Iz._32wnh + ._1M_Iz ._1h3B_').text
                            # print('이용정보 : ' + place_info)
                            place_list.append(place_info)
                        except Exception as e:
                            place_info = ""
                            # print('이용정보 :' + place_info)
                            place_list.append(place_info)

                        # place 소개
                        try:
                            place_introduce_open = driver.find_element_by_css_selector(
                                '.place_section_content ._3__3i ._1h3B_ .M_704')
                            place_introduce_open.click()
                            time.sleep(1)

                            # 내용 더 보기를 클릭함으로 해당 클래스 안에 text가 더 노출되며 동시에 해당 클래스에 클래스명이 추가된다.
                            # 추가된 클래스명은 html변수에 driver.page_source로 담겨있지 않기 때문에 새롭게 선언해준다.
                            driver.switch_to.default_content()
                            driver.switch_to.frame('entryIframe')
                            # detail page의 html
                            html = driver.page_source
                            soup = BeautifulSoup(html, "html.parser")

                            place_introduce = soup.select_one(
                                '.place_section_content ._3__3i ._1h3B_ .M_704 .WoYOw').text
                            # print('소개 : ' + place_introduce)
                            place_list.append(place_introduce)
                        except Exception as e:
                            place_introduce = ""
                            # print('소개 : ' + place_introduce)
                            place_list.append(place_introduce)

                        # place 운영시간
                        try:
                            place_introduce_open = driver.find_element_by_css_selector(
                                '.place_section_content ._2KHqk ._1h3B_ ._2BDci')
                            place_introduce_open.click()
                            time.sleep(1)

                            # 내용 더 보기를 클릭함으로 해당 클래스 안에 text가 더 노출되며 동시에 해당 클래스에 클래스명이 추가된다.
                            # 추가된 클래스명은 html변수에 driver.page_source로 담겨있지 않기 때문에 새롭게 선언해준다.
                            driver.switch_to.default_content()
                            driver.switch_to.frame('entryIframe')
                            # detail page의 html
                            html = driver.page_source
                            soup = BeautifulSoup(html, "html.parser")

                            # 운영시간이 여러개로 입력되어 있을 경우
                            try:
                                place_time_lists = driver.find_elements_by_css_selector(
                                    '.place_section_content ._2KHqk ._1h3B_ ._2BDci._1OkoP ._2ZP3j ._20pEw')

                            # 운영시간이 힌개만 입력되어 있을 경우
                            except Exception as e:
                                place_time_lists = driver.find_elements_by_css_selector(
                                    '.place_section_content ._2KHqk ._1h3B_ ._2BDci._1OkoP ._2ZP3j')
                            place_time_Arr = []

                            for place_time_list in place_time_lists:
                                place_time = place_time_list.text
                                # print('영업시간 : ' + place_time)
                                place_time_Arr += [place_time]

                            place_list.append(place_time_Arr)
                        except Exception as e:
                            place_time = ""
                            # print('영업시간 : ' + place_time)
                            place_list.append(place_time)

                        # place image
                        try:
                            image_section = driver.find_element_by_css_selector(
                                '.place_detail_wrapper ._2MDmw ._tab-menu:last-child')

                            image_section.click()

                        # 시간 지연
                            time.sleep(2)

                            images = driver.find_elements_by_css_selector(
                                ".place_section ._3TiO6._1wsFm ._2OSze .place_thumb img")
                            print(len(images))

                        # 해당 place의 img 갯수
                            count = 1
                            imagesArr = []
                            for image in images:
                                time.sleep(1)
                                path = 'C:\\Seungmin\\python\\crawling\\images\\ '
                                # 이미지 url 저장
                                imgUrl = image.get_attribute("src")
                                # print('이미지 ' + str(count) + ' : ' + imgUrl)
                                # 이미지 url을 저장한 list
                                imagesArr += [imgUrl]
                                # 이미지 파일 저장
                                # urllib.request.urlretrieve(imgUrl, path + str(i) + '_' + str(count) + ".jpg")
                                count = count + 1

                            place_list.append(imagesArr)

                        except Exception as e:
                            # print('이미지 : 없음')
                            place_list.append('')
                        # =========== place 정보 추출 완료 ============

                        # placeLists배열에 place_list 배열의 값을 입력
                        placeLists.append(place_list)
                        time.sleep(1)
                    # 광고일 경우 continue로 패스
                    else:
                        continue

            # 다음 선택할 list가 없을 경우 while 종료
            except Exception as e:
                print(e)
                break

    except Exception as e:
        print(e)

# csv 파일에 입력
writer.writerows(placeLists)


driver.close
file.close()
