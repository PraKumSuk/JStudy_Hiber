In ManageEmployee.java


Session session = sessionFactory.openSession( new MyInterceptor());

the above line is the one which enables Interceptor to work.....However its throwing a compile error

and Interceptors are not working....

However when new myInterceptor() is removed program compiles well and runs but interceptors still does not work