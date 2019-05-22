To run API locally:
```
git clone https://github.com/sbayer55/gif-collector.git
env "giphy.apiToken"="SICyE6VbRPukd12rrIwbdC2QmwNjSBYH" bash
./mvnw clean install
./mvnw spring-boot:run

# default username: steven
# default password: password
```

To serve UI locally:
```
git clone https://github.com/sbayer55/gif-collector-ui.git
cd gif-collector-ui
npm install
npm start
```