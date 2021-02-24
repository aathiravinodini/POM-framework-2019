from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager
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
driver.get("https://watchnext.bearcyber.com/")
driver.find_element(By.NAME,'username').send_keys("aathira@gmail.com")
driver.find_element(By.NAME,'password').send_keys("athira123")
driver.find_element(By.XPATH,"//button[@type ='submit']").click()
driver.quit()