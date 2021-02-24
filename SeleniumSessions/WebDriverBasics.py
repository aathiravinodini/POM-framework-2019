
from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.select import Select
import time

chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument("--incognito")
def select_values(element,value):
    select = Select(element)
    select.select_by_visible_text(value)


driver = webdriver.Chrome(ChromeDriverManager().install())
driver.implicitly_wait(10)
driver.get("https://watchnext.bearcyber.com/register")
driver.maximize_window()
driver.implicitly_wait(10)
name = driver.find_element(By.NAME,'first_name')
username = driver.find_element(By.NAME,'username')
email = driver.find_element(By.NAME,'email')
phone = driver.find_element(By.NAME,'phone')
password = driver.find_element(By.NAME,'password')
signup = driver.find_element(By.XPATH,"//button[@type ='submit']")
dob = driver.find_element(By.NAME,'dob')
month = driver.find_elements(By.CSS_SELECTOR,'.react-datepicker__month-select')
year = driver.find_elements(By.CSS_SELECTOR,'.react-datepicker__year-select')



name.send_keys("Athira")
username.send_keys("aathira")
email.send_keys("athira@gmail.com")

dob.click()
select_values(month,'December')
select_values(year,'1988')




phone.send_keys("630456778")
password.send_keys("athira123")
signup.click()

driver.quit()