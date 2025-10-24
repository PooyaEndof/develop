# number 8 of project article

### Reference Documentation

**to achieve tax and insurance of salary each of person in Iran**

* first go to link:(http://localhost:8080/tax/swagger-ui/index.html#)
* second go pass through the login page(user: user password: user)
* third use swagger to set total salary in month and the response is calculate net salary, insurance, tax

### Guides

the project has these features:

* h2 DB for keeping 2 tables that one of them is range of tax salary and another is base information
* in this app both language has been supported (en,fa)
* common module is that module we keep error enum and exception handler 
* tax parent is m odule that keep both tax and common module in it
* don't forget to run clean package in tax_parent maven. after that run Tax application in spring boot



