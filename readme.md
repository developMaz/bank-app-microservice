#Main information
The application for creating credit information and storage in database. It consits of three modules: 
- one for product information
- second for customer information
- third for credit and control information
- fourth element is external database

The application enables the execution of two commands: 
- CreateCredit 
- Get Credit

#Create Credit
CreateCredit need for start  to get information about:
- Customer: first name, second name and pesel (identification code in polish public system)
- Product: product name and product value
- Credit: credit name

1. CreditComponentController receives information (described above) as a three objects with their arguments (Customer, Product, Credit).
2. Controller generate credit number and next adding it to all objects.
3. Controller call external service that supports product and creating new product with assigned the credit number and save it in db.
4. Controller call external service that supports customer and creating new customer with assigned the credit number and save it in db.
5. Controller save the credit info.
6. Controller return credit number.

#Get Credit
GetCredit return all credits credentials with additional information about product, customer and credit. 

1. GetCredit receive empty call
2. Controller acquires all credit data from credit service.
3. Controller acquires all customer data from external customer service.
4. Controller acquires all product data from external product service. 
5. Controller transform all data to list of credits.
6. Controller return list of credit information.

Returned list contains credit number and object with information about this credit. 
