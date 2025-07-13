# Exemplos de Requisições

## Cadastrar Paciente
POST /pacientes  
Content-Type: application/json

{
  "name": "João Silva",
  "age": 30,
  "cpf": "12345678901",
  "history": ["Dengue", "Febre"]
}

## Listar Pacientes

Listar todos os pacientes:  
GET /pacientes

Listar apenas pacientes ativos:  
GET /pacientes?status=ACTIVE

Listar apenas pacientes inativos:  
GET /pacientes?status=INACTIVE

## Atualizar Status do Paciente
PUT /pacientes/12345678901/status

## Adicionar Histórico Médico
POST /pacientes/12345678901/historico  
Content-Type: application/json

{
  "entry": "Paciente relatou dor de cabeça"
}

## Remover Paciente
DELETE /pacientes/12345678901
