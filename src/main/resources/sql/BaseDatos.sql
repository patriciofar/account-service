-- Clientes
INSERT INTO clientes (cliente_id, contrasena, estado, nombre, genero, edad, identificacion, direccion, telefono)
VALUES
    ('660e8400-e29b-41d4-a716-446655440000', '1234', true, 'Jose Lema', 'Masculino', 30, '1234567890', 'Otavalo sn y principal', '098254785'),
    ('660e8400-e29b-41d4-a716-446655440001', '5678', true, 'Marianela Montalvo', 'Femenino', 25, '0987654321', 'Amazonas y NNUU', '097548965'),
    ('660e8400-e29b-41d4-a716-446655440002', '1245', true, 'Juan Osorio', 'Masculino', 35, '1122334455', '13 junio y Equinoccial', '098874587');

-- Cuentas
INSERT INTO cuentas (cuenta_id, numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id)
VALUES
    ('770e8400-e29b-41d4-a716-446655440000', '478758', 'Ahorro', 2000.00, true, '660e8400-e29b-41d4-a716-446655440000'),
    ('770e8400-e29b-41d4-a716-446655440001', '225487', 'Corriente', 100.00, true, '660e8400-e29b-41d4-a716-446655440001'),
    ('770e8400-e29b-41d4-a716-446655440002', '495878', 'Ahorro', 0.00, true, '660e8400-e29b-41d4-a716-446655440002'),
    ('770e8400-e29b-41d4-a716-446655440003', '496825', 'Ahorro', 540.00, true, '660e8400-e29b-41d4-a716-446655440001'),
    ('770e8400-e29b-41d4-a716-446655440004', '585545', 'Corriente', 1000.00, true, '660e8400-e29b-41d4-a716-446655440000');

-- Movimientos
INSERT INTO movimientos (movimiento_id, fecha, tipo_movimiento, valor, saldo, cuenta_id)
VALUES
    ('880e8400-e29b-41d4-a716-446655440000', '2022-02-10', 'Depósito', 600.00, 700.00, '770e8400-e29b-41d4-a716-446655440001'),
    ('880e8400-e29b-41d4-a716-446655440001', '2022-02-08', 'Retiro', -540.00, 0.00, '770e8400-e29b-41d4-a716-446655440003'),
    ('880e8400-e29b-41d4-a716-446655440002', '2022-02-10', 'Retiro', -575.00, 1425.00, '770e8400-e29b-41d4-a716-446655440000'),
    ('880e8400-e29b-41d4-a716-446655440003', '2022-02-10', 'Depósito', 150.00, 150.00, '770e8400-e29b-41d4-a716-446655440002');