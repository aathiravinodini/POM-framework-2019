from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import Select
import time
#generic mtd
def select_Values(element,value):
   select =  Select(element)
   select.select_by_visible_text(value)



driver = webdriver.Chrome(ChromeDriverManager().install())
driver.get('https://www.orangehrm.com/orangehrm-30-day-trial/')
driver.maximize_window()
industry_ele= driver.find_element(By.ID,'Form_submitForm_Industry')
country_ele = driver.find_element(By.ID,'Form_submitForm_Country')
#industry_ele.click()
#select = Select(industry_ele)
#select.select_by_visible_text('Education')

#select_Values(industry_ele,'Education')
#select_Values(country_ele,'Australia')

#select = Select(industry_ele)
#option_list = select.options
#for ele in option_list:
   # print(ele.text)
    #if ele.text == 'Education':
       # ele.click()
       # break

indusrty_List = driver.find_elements(By.XPATH,"//select[@id='Form_submitForm_Industry']")
print(len(indusrty_List))

for ele in indusrty_List:
    print(ele.text)
    if ele == 'Education':
        ele.click()
        break
