const { Model, DataTypes } = require('sequelize')

class event_hardwares extends Model{
	static init(sequelize){
		super.init({
			modelo: DataTypes.STRING,
			memoryRam: DataTypes.STRING,
			GPU: DataTypes.STRING,
			hardDisk: DataTypes.STRING,
			UserId: DataTypes.INTEGER,
		}, {
			sequelize
		})
	}
}

module.exports = event_hardwares;


// module.exports = (sequelize, DataTypes) => {
//     let Usuario = sequelize.define('Usuario',{
// 		iduser: {
// 			field: 'IDUSER',
// 			type: DataTypes.INTEGER,
// 			primaryKey: true,
// 			autoIncrement: true
// 		},		
// 		loginuser: {
// 			field: 'LOGINUSER',
// 			type: DataTypes.STRING,
// 			allowNull: false
// 		},
// 		senha: {
// 			field: 'SENHA',
// 			type: DataTypes.STRING,
// 			allowNull: false
// 		},
// 		nome: {
// 			field: 'NOME',
// 			type: DataTypes.STRING,
// 			allowNull: false
// 		},
// 		email: {
// 			field: 'EMAIL',
// 			type: DataTypes.STRING,
// 			allowNull: false
// 		},
// 		telefone: {
// 			field: 'TELEFONE',
// 			type: DataTypes.STRING,
// 			allowNull: false
// 		}
// 	}, 
// 	{
// 		tableName: 'USUARIO', 
// 		freezeTableName: true, 
// 		underscored: true,
// 		timestamps: false,
// 	});

//     return Usuario;
// };
