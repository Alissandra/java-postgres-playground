# Como ficaria o campo  statement.setString(1, uf); caso eu fizesse uma consulta com duas variáveis? por exemplo, buscar por 2 estados diferentes.


## Vc precisaria ter 2 parâmetros. Por exemplo:

## var sql = "select * from estado where uf = ? or uf = ?";

## statement.setString(1, uf1);
## statement.setString(2, uf2);
