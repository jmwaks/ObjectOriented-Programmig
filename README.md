=======================================
 ObjectOriented-Programming with REST
=======================================


Prerequisites:

+ Up and running Tomcat8
+ JUNIT 4



:background:

    This project attemps to workings of a wine club. There's the administrator, club mebers who order wine on a monthly,
    basis and a delivery company that gets the ordered wines to the members.
    The project is implemented in Java and has a RESTful interface. 


Sample REST calls implemented 
-----------------------------

      + POST /sub
      + PUT /sub/{uid}
      + GET /sub/{uid}
      + GET /sub/{uid}/search
      + GET /sub/{uid}/shipments
      + GET /sub/{uid}/shipments/{sid}
      + PUT /sub/{uid}/shipments/{sid}
