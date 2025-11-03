Feature: Gestión de empleados en OrangeHRM

  @e2e
  Scenario: Agregar y validar un nuevo empleado
    Given el administrador inicia sesión en OrangeHRM
    When agrega un nuevo empleado con nombre "Juan" y apellido "Pérez"
    And sube una foto de perfil para el empleado
    And busca el empleado "Juan Pérez" en el módulo de Directorio
    Then valida que la información del empleado se haya guardado correctamente
