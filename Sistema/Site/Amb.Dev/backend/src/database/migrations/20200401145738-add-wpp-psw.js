'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.addColumn(
      'monitor_users',
      'whatsapp',{
        type: Sequelize.STRING,
        allowNull: false,
      }
    );
  },

  down: (queryInterface, Sequelize) => {
      return queryInterface.dropTable('monitor_users');
  }
};
