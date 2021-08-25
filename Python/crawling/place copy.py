from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup
import time 
import urllib.request

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

for i in range(50):

    driver.switch_to.frame('searchIframe')
    
    
    i += 1
    content = driver.find_element_by_css_selector('#_pcmap_list_scroll_container ul li:nth-child(' + str(i) + ') ._3ZU00 ._3LMxZ:first-child')
    
    
    # place name click detail page load
    content.click()
    time.sleep(3)

    driver.switch_to.default_content()
    driver.switch_to.frame('entryIframe')

    # detail page의 html
    html = driver.page_source
    soup = BeautifulSoup(html, "html.parser")

    # place name
    place_name = soup.select_one('#_title ._3XamX').text
    print('매장명 : ' + place_name)    


    # place tel
    place_tel = soup.select_one('.place_section_content ._3xPmJ ._1h3B_ ._3ZA0S').text
    print('전화번호 : ' + place_tel) 

    # place address
    place_address = soup.select_one('.place_section_content ._1aj6- ._1h3B_ ._2yqUQ').text
    print('주소 : ' + place_address) 

    # place introduce
    place_introduce_open = driver.find_element_by_css_selector('.place_section_content ._3__3i ._1h3B_ .M_704')
    place_introduce_open.click()
    time.sleep(0.5)

    place_introduce = soup.select_one('.place_section_content ._3__3i ._1h3B_ .M_704._4FheO .WoYOw').text
    print('소개 : ' + place_introduce) 

    # place time
    place_introduce_open = driver.find_element_by_css_selector('.place_section_content ._2KHqk ._1h3B_ ._2BDci._1OkoP') 
    place_introduce_open.click()
    time.sleep(0.5)

    place_time_lists = soup.select_one('.place_section_content ._2KHqk ._1h3B_ ._2BDci._1OkoP._3XVfx ._20pEw').text
    for place_time_list in place_time_lists :
        print('영업시간 : ' + place_time_list) 


    # place_info

    # place_introduce = soup.select_one('.place_section_content .undefined ._1h3B_').text
    # print('이용정보 : ' + place_introduce) 




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
        #image.click()
        time.sleep(3)
        imgUrl = driver.find_element_by_css_selector(
            ".place_section ._3TiO6._1wsFm ._2OSze .place_thumb img").get_attribute("src")
        urllib.request.urlretrieve(imgUrl, str(i) + '_' + str(count) + ".jpg")
        count = count + 1


    driver.switch_to.default_content()




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
