# Power of Attorney Service
  - Power of attorney details such as grantee, grantor and account details (/power-of-attorneys/{id})
  - Details for card products authorized by the power of attorney (/debit-cards/{id} and /credit-cards/{id})
  - Account details (/accounts/{id})
  
## Exercise!
  - ~~Build a REST API presenting aggregated information from different services~~
  - Only show data that a user is actually authorized for
  - ~~Handle any server errors you might run into gracefully~~
  - Don't return inactive products or accounts
  - (Optional) Expose the API over HTTPS
  - Perform whatever validation seems necessary
 
## Project outline

- The project was built in a contract-first manner, the public API and models are defined in `resources/contract.yml` 
- The API interface and models are generated
- Swagger UI is accessible from `http://localhost:8080/swagger-ui.html`
- jacoco coverage reports can be found at `build/jacoco-reports`
- Integration tests use the Cucumber framework, feature files are in `src/test/resources`
- In mempory H2 database is used

---

### Startup guide

* build the project with gradle `gradle build`
* Start the services with `docker-compose up`
* start the application by either `java -jar build/libs/poa-api-0.0.1-SNAPSHOT.jar`
* check `http://localhost:8080/swagger-ui.html` for available endpoints
* import `src/main/resources/contract.yml` to PostMan


