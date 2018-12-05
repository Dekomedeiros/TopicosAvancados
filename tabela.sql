-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`motorista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`motorista` (
  `idmotorista` INT NOT NULL AUTO_INCREMENT,
  `nomeMotorista` VARCHAR(100) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `cnh` VARCHAR(11) NOT NULL,
  `tipoCnh` VARCHAR(2) NOT NULL,
  `enderecoMotorista` VARCHAR(100) NOT NULL,
  `disponivel` TINYINT NOT NULL,
  PRIMARY KEY (`idmotorista`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`veiculo` (
  `idveiculo` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(7) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `ano` INT(4) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `idmotorista` INT NOT NULL,
  PRIMARY KEY (`idveiculo`),
  INDEX `idmotorista_idx` (`idmotorista` ASC) VISIBLE,
  CONSTRAINT `idmotorista`
    FOREIGN KEY (`idmotorista`)
    REFERENCES `mydb`.`motorista` (`idmotorista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`roteiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`roteiro` (
  `idroteiro` INT NOT NULL AUTO_INCREMENT,
  `idVeiculo` INT NOT NULL,
  `dataRoteiro` DATE NOT NULL,
  PRIMARY KEY (`idroteiro`),
  INDEX `idVeiculo_idx` (`idVeiculo` ASC) VISIBLE,
  CONSTRAINT `idVeiculo`
    FOREIGN KEY (`idVeiculo`)
    REFERENCES `mydb`.`veiculo` (`idveiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`objeto` (
  `idobjeto` INT NOT NULL AUTO_INCREMENT,
  `dataCadastro` DATE NOT NULL,
  `status` VARCHAR(1) NOT NULL,
  `peso` DOUBLE NOT NULL,
  `dataEntrega` DATE NULL,
  `idLocalizador` VARCHAR(45) NULL,
  `nomeRemetente` VARCHAR(45) NULL,
  `enderecoRemetente` VARCHAR(45) NULL,
  `dataDeposito` DATE NULL,
  `nomeDestinatario` VARCHAR(45) NULL,
  `enderecoDestinatario` VARCHAR(45) NULL,
  PRIMARY KEY (`idobjeto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`roteiroObjeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`roteiroObjeto` (
  `idroteiro` INT NOT NULL,
  `idobjeto` INT NOT NULL,
  PRIMARY KEY (`idroteiro`, `idobjeto`),
  INDEX `fk_roteiro_has_objeto_objeto1_idx` (`idobjeto` ASC) VISIBLE,
  INDEX `fk_roteiro_has_objeto_roteiro1_idx` (`idroteiro` ASC) VISIBLE,
  CONSTRAINT `fk_roteiro_has_objeto_roteiro1`
    FOREIGN KEY (`idroteiro`)
    REFERENCES `mydb`.`roteiro` (`idroteiro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roteiro_has_objeto_objeto1`
    FOREIGN KEY (`idobjeto`)
    REFERENCES `mydb`.`objeto` (`idobjeto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
