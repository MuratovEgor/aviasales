# Автотесты для https://www.aviasales.ru/
___
## Используемые технологии и инструменты
| GitHub | IntelliJ IDEA | Java | Gradle | Junit5 | Selenide |
|:------:|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> |

| Jenkins | Selenoid | Allure Report | Allure TestOps | Telegram |
|:--------:|:-------------:|:---------:|:-------:|:--------:|
| <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |
___


## Используемые параметры по умолчанию [для запуска через Jenkins](https://jenkins.autotests.cloud/job/MuratovEgor_HomeWork_12/build?delay=0sec) <a href="https://www.jetbrains.com/idea/"><img src="./images/Jenkins.svg" width="30" height="30"  alt="Jenkins"/></a>

* BROWSER (default chrome)
* BROWSER_VERSION (default 90.0)
* BROWSER_SIZE (default 1920x1080)
* REMOTE_DRIVER_URL (url address from selenoid or grid. default selenoid.autotests.cloud)
* THREADS (number of threads to run. default 1)
* ALLURE_NOTIFICATIONS_VERSION (default 3.0.1)

![alt "Запуск через Jenkins"](./images/jenkinsRun.png)

### Run tests with filled local.properties:

```bash
gradle clean test
```

### Run tests with not filled local.properties:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Serve allure report:

```bash
allure serve build/allure-results
```

## Список тестов (для примера) - хранение и анализ в Allure TestOps
![alt "Allure TestOps"](./images/allure2.png "Allure TestOps")


## Оповещение о результатах прохождения тестов через бот в телеграмме <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="30" height="30"  alt="Telegram"/></a>

![alt "бот в телеграмме"](./images/bot.png "бот в телеграмме")

## Анализ результатов в Jenkins через Allure Reports
![alt "Allure Reports"](./images/jenkinsResult.png "Allure Reports")
## Анализ результатов в Allure TestOps <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"  alt="Allure EE"/></a>

![alt "Allure TestOps"](./images/allure1.png "Allure TestOps")
## Видео прохождения тестов, взятое из среды выполнения (из Selenoid) <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a>

![alt "Video from Selenoid"](./images/Video.gif "Video from Selenoid")