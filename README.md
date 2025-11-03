# OrangeHRM UI + API

Proyecto completo de automatización utilizando:

Pruebas UI (login, agregar empleado, buscar y validar información)  
Pruebas API (creación y validación de empleado)  

Ejecución local
mvn clean verify

El reporte se genera en:
target/site/serenity/index.html


Ejecutar solo pruebas de API
bash
mvn clean verify -Dcucumber.filter.tags="@api"

Configuración de Jira
private static final String JIRA_BASE = "https://tudominio.atlassian.net";
private static final String JIRA_USER = "tuemail@empresa.com";
private static final String JIRA_TOKEN = "tu_api_token";
private static final String PROJECT_KEY = "HRM";

Integración BrowserStack
En serenity.properties, reemplaza:

browserstack.username=YOUR_USERNAME
browserstack.accessKey=YOUR_ACCESS_KEY