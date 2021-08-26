from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup
import time 
import urllib.request
import re

# 크롬 웹드라이버 연결
options = webdriver.ChromeOptions()
options.add_experimental_option("excludeSwitches", ["enable-logging"])

driver = webdriver.Chrome(
    options=options, executable_path="chromedriver")
driver.get("https://map.naver.com/v5/search")


# 시간 지연
time.sleep(2)

# 검색입력
elem = driver.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")
elem.send_keys("마포구 헬스장")
elem.send_keys(Keys.RETURN)


# 5초 delay
time.sleep(2)

# 처음 화면의 html
html = driver.page_source
soup = BeautifulSoup(html, "html.parser")


# last_height1 = driver.execute_script("return document.body.scrollHeight")
# print(last_height1)

# list_iframe으로 전환
# list_iframe = driver.find_element_by_id('searchIframe')
#driver.switch_to.frame('searchIframe')


#detail_iframe link
#contents = driver.find_element_by_css_selector('_pcmap_list_scroll_container ul li:nth-child(' + li_count + ') ._3ZU00 ._3LMxZ:first-child')
#contents = 50

#print(len(contents))

li_count = 1

# 한 페이징에 출력되는 place list는 최대 50개
advertis_count = 0

i = 0
driver.switch_to.frame('searchIframe')


# 한 페이지의 place 리스트 무한 반복하여 클릭
while(True):

    # searchiframe으로 전환
    driver.switch_to.default_content()
    driver.switch_to.frame('searchIframe')
        
    # list li의 idx값
    i += 1

    # 한 페이지에 클릭할 place가 없을 경우 break를 하기 위한 체크 값
    list_ldx_chk = bool(('#_pcmap_list_scroll_container ul li:nth-child(' + str(i) + ')'))
    print('list_ldx_chk' + str(list_ldx_chk))

    # 클락할 place 리스트가 있을 경우
    if list_ldx_chk :

        # 광고 list 제외하기 위한 체크 값
        advertis_chk = bool(driver.find_elements_by_css_selector('#_pcmap_list_scroll_container ul li:not(._293u6):nth-child(' + str(i) + ')'))


        # 광고 list에 붙는 class명이 없을 경우(광고가 아닐 경우)
        if advertis_chk :
            
            print('advertis_chk' + str(advertis_chk))

            # place list 클릭해서 detailpage open
            content = driver.find_element_by_css_selector('#_pcmap_list_scroll_container ul li:nth-child(' + str(i) + ') ._3ZU00 ._3LMxZ:first-child')
            content.click()
            time.sleep(3)

            # place 이름 클릭하면 detailpage iframe으로 driver html 전환
            driver.switch_to.default_content()
            driver.switch_to.frame('entryIframe')

            # detail page의 html
            html = driver.page_source
            soup = BeautifulSoup(html, "html.parser")


            # ========== place 정보 추출 ==============


            # place 이름
            place_name = soup.select_one('#_title ._3XamX').text
            print('매장명 : ' + place_name)    

            # place 전화번호
            try :
                place_tel = soup.select_one('.place_section_content ._3xPmJ ._1h3B_ ._3ZA0S').text
                print('전화번호 : ' + place_tel) 
            except Exception as e :
                place_tel = ''
                print('전화번호 : ' + place_tel)

            # place 위치
            place_address = soup.select_one('.place_section_content ._1aj6- ._1h3B_ ._2yqUQ').text
            print('주소 : ' + place_address) 

            # place 소개
            place_introduce_open = driver.find_element_by_css_selector('.place_section_content ._3__3i ._1h3B_ .M_704')
            place_introduce_open.click()
            time.sleep(2)

            # 내용 더 보기를 클릭함으로 해당 클래스 안에 text가 더 노출되며 동시에 해당 클래스에 클래스명이 추가된다. 
            # 추가된 클래스명은 html변수에 driver.page_source로 담겨있지 않기 때문에 새롭게 선언해준다. 
            driver.switch_to.default_content()
            driver.switch_to.frame('entryIframe')
            # detail page의 html
            html = driver.page_source
            soup = BeautifulSoup(html, "html.parser")

            try :
                
                place_introduce = soup.select_one('.place_section_content ._3__3i ._1h3B_ .M_704 .WoYOw').text
                print('소개 : ' + place_introduce) 
            except Exception as e :
                place_introduce = ""
                print('소개 : ' + place_introduce)


            # place 운영시간
            place_introduce_open = driver.find_element_by_css_selector('.place_section_content ._2KHqk ._1h3B_ ._2BDci._1OkoP') 
            place_introduce_open.click()
            time.sleep(0.5)
            
            # 내용 더 보기를 클릭함으로 해당 클래스 안에 text가 더 노출되며 동시에 해당 클래스에 클래스명이 추가된다. 
            # 추가된 클래스명은 html변수에 driver.page_source로 담겨있지 않기 때문에 새롭게 선언해준다. 
            driver.switch_to.default_content()
            driver.switch_to.frame('entryIframe')
            # detail page의 html
            html = driver.page_source
            soup = BeautifulSoup(html, "html.parser")

            place_time_lists = driver.find_elements_by_css_selector('.place_section_content ._2KHqk ._1h3B_ ._2BDci._1OkoP ._2ZP3j ._20pEw')

            for place_time_list in place_time_lists :
                print('영업시간 : ' + place_time_list.text) 


            # place 이용정보
            try :
                place_info = soup.select_one('.place_section_content li.undefined:last-child ._1h3B_').text
                print('이용정보 : ' + place_info) 
            except Exception as e :
                place_info = ""
                print('이용정보 :' + place_info)


            # place image
            image_section = driver.find_element_by_css_selector('.place_detail_wrapper ._2MDmw ._tab-menu:last-child')

            image_section.click()
            
            #시간 지연
            time.sleep(3)

            images = driver.find_elements_by_css_selector(".place_section ._3TiO6._1wsFm ._2OSze .place_thumb img")
            print(len(images))

            # 해당 place의 img 갯수
            count = 1
            for image in images:
                time.sleep(0.5)
                path = 'C:\\Seungmin\\python\\crawling\\images\\ '
                imgUrl = image.get_attribute("src")
                print('이미지 ' + str(count) +  ' : ' + imgUrl)
                # 파일 저장
                urllib.request.urlretrieve(imgUrl, path + str(i) + '_' + str(count) + ".jpg")
                count = count + 1

            # =========== place 정보 추출 완료 ============

        # 광고일 경우 continue로 패스
        else :
            continue
        
        # while문으로 다시 진행
        continue

    # 다음 선택할 list가 없을 경우 while 종료
    else :
        break
    



# images = driver.find_elements_by_css_selector(".rg_i.Q4LuWd")

# count = 1
# for image in images:
#     image.click()
#     time.sleep(3)
#     imgUrl = driver.find_element_by_css_selector(
#         ".n3VNCb").get_attribute("src")
#     urllib.request.urlretrieve(imgUrl, str(count) + ".jpg")
#     count = count + 1


# assert "Python" in driver.title
# elem = driver.find_element_by_name("q")
# elem.clear()
# elem.send_keys("pycon")
# elem.send_keys(Keys.RETURN)
# assert "No results found." not in driver.page_source
# driver.close()
