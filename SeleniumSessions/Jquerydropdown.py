from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import time
#single selection
def select_values(optionList,value):
    for ele in optionList:
        print(ele.text)
        if ele.text == value:
          ele.click()
          break
#multiselection and single selection
def select_Allvalues(optionList,value):
    if not value == 'all':
        for ele in optionList:
            print(ele.text)
            for k in range(len(value)):
             if ele.text == value[k]:
                ele.click()
                break
    else:
        try:
          for ele in optionList:
            ele.click
        except Exception as e:
            print(e)

driver = webdriver.Chrome(ChromeDriverManager().install())
driver.implicitly_wait(10)
driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/")
time.sleep(2)
driver.find_element(By.ID,'justAnInputBox').click()
drop_list = driver.find_elements(By.CSS_SELECTOR,'span.comboTreeItemTitle')
value_list = ['choice 2 2','choice 3','choice 6 1']
#for ele in drop_list:
   # print(ele.text)
   # if ele.text == "choice 2 2":
       # ele.click()
       # break

#select_values(drop_list,"choice 2 2")
#select_values(drop_list,"choice 3")
#select_values(drop_list,"choice 6 1")



select_Allvalues(value_list)
select_Allvalues('all')
select_Allvalues('choice 1')











