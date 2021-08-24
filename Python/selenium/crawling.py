from selenium import webdriver
from selenium.webdriver.common.keys import Keys
#from bs4 import BeautifulSoup
import time
import urllib.request

driver = webdriver.Chrome("./chromedriver")
driver.get("https://map.naver.com/v5/search")

time.sleep(2)
elem = driver.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")

elem.send_keys("마포구 헬스장")
elem.send_keys(Keys.RETURN)

for p in range(20):
    # 5초 delay
    time.sleep(2)

    js_script = "document.querySelector(\"body > app > layout > div > div.container > div.router-output > "\
                "shrinkable-layout > search-layout > search-list > search-list-contents > perfect-scrollbar\").innerHTML"
    raw = driver.execute_script("return " + js_script)

    #html = BeautifulSoup(raw, "html.parser")


#images = driver.find_elements_by_css_selector(".rg_i.Q4LuWd")

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
