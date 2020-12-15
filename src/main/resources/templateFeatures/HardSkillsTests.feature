Feature: Escenarios prueba de HardSkills

  Scenario: Obtener AccessToken exitosamente
    Given que existe un usuario con los siguientes datos
      | username | juan         |
      | password | ValidPass123 |

    When el usuario solicita un AccessToken al API usando sus credenciales

    Then el API responde con un codigo "200"
    And el API retorna un AccessToken

  Scenario: Intento de obtener AccessToken con credenciales invalidas
    Given que existe un usuario con los siguientes datos
      | username | juan         |
      | password | ValidPass123 |

    When el usuario solicita un AccessToken al API usando creedenciales invalidas

    Then el API responde con un codigo "401"
    And el API retorna como mensaje "Unauthorized"

  Scenario: Obtener información detallada de la cuenta del usuario exitosamente
    Given que existe un usuario con los siguientes datos
      | username | juan         |
      | password | ValidPass123 |

    And el usuario solicita un AccessToken al API usando sus credenciales

    When el usuario solicita la informacion de su cuenta al API usando el AccessToken generado

    Then el API responde con un codigo "200"
    And el API retrona el tipo de cuenta
    And el API retorna el ID de la cuenta
    And el API retorna el nombre del propietario de la cuenta
    And el API retorna el dinero guardado en la cuenta

  Scenario: Intento de obtener información detallada de la cuenta del usuario sin un AccessToken valido
    Given que existe un usuario con los siguientes datos
      | username | juan         |
      | password | ValidPass123 |

    When el usuario solicita la informacion de su cuenta al API usando AccessToken invalido

    Then el API responde con un codigo "401"
    And el API retorna como mensaje "Unauthorized"

  Scenario: Realizar transferencia de dinero exitosamente
    Given que existe un usuario con los siguientes datos
      | username | juan         |
      | password | ValidPass123 |

    And el usuario solicita un AccessToken al API usando sus credenciales

    When el usuario solicita hacer una transferencia usando un AccessToken valido a la siguiente cuenta
      | owner       | Pedro Jimenez |
      | accountID   | 10002000      |
      | accountType | Ahorros       |
      | amount      | 100000        |

    Then el API responde con un codigo "200"
    And el API retorna como mensaje "Transferencia realizada exitosamente"

  Scenario: Intento de transferencia de dinero fallida usando AccessToken invalido
    Given que existe un usuario con los siguientes datos
      | username | juan         |
      | password | ValidPass123 |

    When el usuario solicita hacer una transferencia usando un AccessToken invalido a la siguiente cuenta
      | owner       | Pedro Jimenez |
      | accountID   | 10002000      |
      | accountType | Ahorros       |
      | amount      | 100000        |

    Then el API responde con un codigo "401"
    And el API retorna como mensaje "Unauthorized"