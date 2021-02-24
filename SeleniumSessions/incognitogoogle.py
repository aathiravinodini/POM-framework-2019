from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager

options = webdriver.ChromeOptions()
options.add_argument("--incognito")

driver = webdriver.Chrome(ChromeDriverManager().install(),options=options)
driver.get('https://google.com')