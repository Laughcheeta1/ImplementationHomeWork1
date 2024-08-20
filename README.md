# This is a RestAPI made with SpringBoot, and implements CRUD capabilities for a simple bakery.

This one only has 3 entities:
*  Product
*  Client
*  Purchase

There is also a basic Exception handling system for very basic exceptions (Not found).

Even tho I do not like it, I didn't add any comment documentation to the functions and all due to their simplicity, and my lack of time.

To be able to run it you have to create a .env file like the following:
```
DATABASE_URL=jdbc:*databaseEngine*//*path of the database (ex: localhost:5432*
DATABASE_USERNAME=*database username*
DATABASE_PASSWORD=*password*
```