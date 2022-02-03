# TAX CALCULATOR APP #

Welcome.....

This is a tax-calculator app that leverages on an existing api to get tax-brackets and calculates tax.
The tax is calculated based on the year and salary(amount). In case of down-time on the tax-brackets api, I have implemented a cache. 

#### Tech used
- Java - language
- Springboot - framework for configuration and ease of build
- docker/dockercompose - compose for containerization
- cache - to store "interview-test-server" api results - to reduce multiple calls


###To Set Up.. ###

Install docker and run the following commands

```bash
make docker
```

###To Test The Application.. ###

On a browser type:
[http://localhost:9031/tax-calc/api/v1/year/{year}/salary/{salary}](http://localhost:9031/tax-calc/api/v1/year/2019/salary/10000)
- example http://localhost:9031/tax-calc/api/v1/year/2019/salary/10000

Or 

on a commandline/terminal type:
curl "http://localhost:9031/tax-calc/api/v1/year/2020/salary/10000"
