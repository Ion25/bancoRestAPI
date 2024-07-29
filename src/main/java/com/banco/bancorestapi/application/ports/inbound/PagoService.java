package com.banco.bancorestapi.application.ports.inbound;

import com.banco.bancorestapi.domain.entities.Pago;

public interface PagoService {

    Pago realizarPago(Integer cuentaId, String proveedor, double monto);

}
