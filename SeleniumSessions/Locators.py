from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager

driver = webdriver.Chrome(ChromeDriverManager().install())
driver.implicitly_wait(10)
driver.get("https://www.amazon.com/")
linksList = driver.find_elements(By.TAG_NAME,'a')
print(len(linksList))
for l in linksList:
    text = l.text
    print(text)
    print(l.get_attribute("href"))

imageList = driver.find_elements(By.TAG_NAME,'img')
print(len(imageList))
for image in imageList:
   print(image.get_attribute("src"))
