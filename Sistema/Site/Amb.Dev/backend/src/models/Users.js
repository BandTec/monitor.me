const { Model, DataTypes } = require('sequelize')

class monitor_users extends Model{
	static init(sequelize){
		super.init({
			name: DataTypes.STRING,
			email: DataTypes.STRING,
		}, {
			sequelize
		})
	}
}

module.exports = monitor_users;


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
