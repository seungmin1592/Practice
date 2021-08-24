from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from bs4 import BeautifulSoup
import time
import urllib.request

# 크롬 웹드라이버 연결
driver = webdriver.Chrome(
    r"C:\Users\User\Documents\GitHub\Practice\Python\selenium\chromedriver.exe")
driver.get("https://map.naver.com/v5/search")

# 시간 지연
time.sleep(2)

# 검색입력
elem = driver.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")
elem.send_keys("마포구 헬스장")
elem.send_keys(Keys.RETURN)


for p in range(20):
    # 5초 delay
    time.sleep(2)

    html = driver.page_source

    soup = BeautifulSoup(html, "html.parser")

    contents = soup.select(
        "#_pcmap_list_scroll_container ._22p-O._2NEjP")

    for content in contents:
        search_box_html = s.select_one(".search_box")

        name = search_box_html.select_one(
            ".title_box .search_title .search_title_text").text
        print("식당명: " + name)
        try:
            phone = search_box_html.select_one(".search_text_box .phone").text
        except:
            phone = "NULL"
        print("전화번호: " + phone)
        address = search_box_html.select_one(".ng-star-inserted .address").text
        print("주소: " + address)

        print("--"*30)


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
