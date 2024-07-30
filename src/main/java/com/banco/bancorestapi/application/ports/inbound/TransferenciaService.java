package com.banco.bancorestapi.application.ports.inbound;

import com.banco.bancorestapi.domain.entities.Transferencia;

public interface TransferenciaService {

    Transferencia realizarTransferencia(Integer cuentaOrigenId, Integer cuentaDestinoId, double monto);

}
