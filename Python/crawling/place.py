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

html = driver.page_source

soup = BeautifulSoup(html, "html.parser")


# last_height1 = driver.execute_script("return document.body.scrollHeight")
# print(last_height1)

# list_iframe으로 전환
list_iframe = driver.find_element_by_id('searchIframe')
driver.switch_to.frame('searchIframe')

# scroll down
SCROLL_PAUSE_TIME = 4

# Get scroll height
last_height = driver.execute_script("return window.document.body.offsetHeight")
#last_height = driver.execute_script("return document.getElementById('searchIframe').document.body.scrollHeight")
print(last_height)
#driver.execute_script("var scroll_f = document.getElementById('searchIframe')")

while True:
    time.sleep(4)
    # Scroll down to bottom
    #driver.execute_script("document.getElementById('searchIframe').contentWindow.setTimeout('this.scrollTo(0, document.body.scrollHeight);',1);")
    test = driver.execute_script("window.scrollTo(0,window.document.body.offsetHeight);")

    print(test)

    # Wait to load page
    time.sleep(SCROLL_PAUSE_TIME)

    # Calculate new scroll height and compare with last scroll height
    new_height = driver.execute_script("return window.document.body.offsetHeight")
    print(new_height)
    if new_height == last_height:
        break
    last_height = new_height


#detail_iframe link
contents = driver.find_elements_by_css_selector('._3ZU00 ._3LMxZ:first-child')
#contents = 50

print(len(contents))

count = 0
for content in contents:
    new_height = driver.execute_script("return window.document.body.offsetHeight")
    print(new_height)
    count += 1
    print(count)
    content.click()
    time.sleep(3)


# detail_box_in = content.select_one("._3LMxZ")

# name = search_box_html.select_one(
#     ".title_box .search_title .search_title_text").text
# print("식당명: " + name)
# try:
#     phone = search_box_html.select_one(".search_text_box .phone").text
# except:
#     phone = "NULL"
# print("전화번호: " + phone)
# address = search_box_html.select_one(".ng-star-inserted .address").text
# print("주소: " + address)

# print("--"*30)


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
