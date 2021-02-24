from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.select import Select
import time

#chrome_options = webdriver.ChromeOptions()
#chrome_options.add_argument("--incognito")

browserName = "chrome"
if browserName=="chrome":
    driver = webdriver.Chrome(ChromeDriverManager().install())
elif browserName == "firefox":
    driver = webdriver.Firefox(executable_path=GeckoDriverManager().install())
elif browserName == "safari":
    driver = webdriver.Safari
else:
    print("Please pass the currect browser name :"+browserName)

driver.implicitly_wait(10)

driver.get("https://watchnext.bearcyber.com/register")
#driver.implicitly_wait(10)
name = driver.find_element(By.NAME,'first_name')
username = driver.find_element(By.NAME,'username')
email = driver.find_element(By.NAME,'email')
dob = driver.find_element(By.NAME,'dob')
month = driver.find_elements(By.CSS_SELECTOR,'.react-datepicker__month-select')
year = driver.find_elements(By.CSS_SELECTOR,'.react-datepicker__year-select')
date = driver.find_elements()
phone = driver.find_element(By.NAME,'phone')
password = driver.find_element(By.NAME,'password')
signup = driver.find_element(By.XPATH,"//button[@type ='submit']")

name.send_keys("Athira")
username.send_keys("aathira")
email.send_keys("athira@gmail.com")
dob.click()
monthDD = Select(month)
monthDD.select_by_value("December")
yearDD = Select(year)
yearDD.select_by_visible_text("1988")
date.click()

phone.send_keys("630456778")
password.send_keys("athira123")
signup.click()

driver.quit()