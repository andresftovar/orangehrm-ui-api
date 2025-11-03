Feature: Pruebas de API de Empleados

  @api
  Scenario: Validar autenticación del administrador
    Given que el administrador accede a la API de OrangeHRM
    When realiza el login con credenciales válidas
    Then la respuesta debe tener el código de estado 302
    And se debe guardar el token de sesión

  @api
  Scenario: Crear un nuevo empleado en OrangeHRM
    Given que el administrador está autenticado en la API
    When crea un nuevo empleado con datos válidos
    Then la respuesta debe tener el código de estado 201
    And el nombre del empleado debe coincidir
