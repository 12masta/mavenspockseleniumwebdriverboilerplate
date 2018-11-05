# Test automation boilerplate

# How to build

To build whole project, install dependencies, run tests etc execute in command line from root directory:

    mvn clean install
    
# Reporting
    
To serve project report, execute following command in terminal from tests directory after running previous command:

    mvn allure:serve 
    
To build project report, execute following command in terminal from tests directory after running previous command:

    mvn allure:report 