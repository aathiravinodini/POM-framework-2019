from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.select import Select
import time
from selenium.webdriver.support import expected_conditions as EC


def select_values(element,value):
    select = Select(element)
    select.select_by_visible_text(value)



driver = webdriver.Chrome(ChromeDriverManager().install())
driver.implicitly_wait(6)
driver.get("https://watchnext.bearcyber.com/register")
driver.maximize_window()
driver.implicitly_wait(2)
name = driver.find_element(By.NAME,'first_name')
username = driver.find_element(By.NAME,'username')
email = driver.find_element(By.NAME,'email')
phone = driver.find_element(By.NAME,'phone')
password = driver.find_element(By.NAME,'password')
signup = driver.find_element(By.XPATH,"//button[text()='Sign Up']")
dob = driver.find_element(By.NAME,'dob')
month = driver.find_elements(By.CSS_SELECTOR,'.react-datepicker__month-select')
year = driver.find_elements(By.CSS_SELECTOR,'.react-datepicker__year-select')

act_chains = ActionChains(driver)

name.send_keys("Athira")
username.send_keys("aathira")
email.send_keys("athira@gmail.com")
dob.send_keys('12/23/1988')
act_chains.double_click()
act_chains.move_to_element(phone).perform()
phone.send_keys("630456778")
password.send_keys("athira123")
signup.click()
driver.quit()