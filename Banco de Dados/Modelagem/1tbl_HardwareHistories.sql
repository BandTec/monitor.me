create table tbl_HardwareHistories(
IdHardwareHistories int primary key identity,
MemoriaRamReg varchar(45),
GPUReg varchar(45),
DiscoRigidoReg varchar(45),
--Id_IdHardware int
--foreign key (Id_IdHardware) references tbl_Hardware(IdHardware)
)