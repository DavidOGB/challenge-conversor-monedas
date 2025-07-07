Este proyecto creae un request para la api de exchange rate, al recibir la respuesta Json se deserealiza para acceder a la informacion recibida por parte del API y que los atributos que nos 
interesan se vean reflejados en un clase record de java. 

Tenemos la clase convertirMoneda, la cual consta de un metodo el cual se llama convertirMoneda(), este es el metodo donde se realiza la creacion del cliente para luego proceder a la creacion del request
y  finalmente a la creacion del response para el manejo de la respuesta de la API. 

Este metodo toma como parametro un String, el cual sera determinado con base en la opcion que el usuario
seleccione en el menu del switch que se encuentra en el main().

En el main se encuentra un buble while dentro del cual se muestra el menu de opciones, al cual prosigue
un menu switch case y dependendiendo del case que se seleccione en ese switch se enviara un parametro 
predeterminado al metodo convertirMoneda() que se encuentra dentro de los casos respectivos del switch.
