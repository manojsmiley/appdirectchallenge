package com.appdirect.subscription.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.appdirect.request.SubscriptionTransaction;
import com.appdirect.subscription.dao.ISubscriptionDao;
import com.appdirect.subscription.enums.SubscriptionStatus;
import com.appdirect.subscription.utility.AppdirectUtils;

@Repository
public class SubscriptionDaoImpl extends AbstractDao implements ISubscriptionDao {
	private static final String INSERT_SUBSCRIPTION = "INSERT INTO `appdirect`.`tbl_substransaction`(`transactionid`,"
			+ "`transdate`, `useraction`, `transstatus`, `productprice`, `chargeprice`, `mode`, `servicename`, `channelname`,"
			+ "`segment`)VALUES (?,NOW(), ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String UPDATE_SUBSCRIPTION = "UPDATE `appdirect`.`tbl_substransaction` SET `useraction` = ?, "
			+ "`transstatus` = ?,`productprice` = ?,`chargeprice` = ?,`mode` = ?,`servicename` = ?,`channelname` = ?,"
			+ "`segment` = ? WHERE `transactionid` = ?";

	private static final String SELECT_SUBSCRIPTION = "SELECT * FROM `appdirect`.`tbl_substransaction` WHERE transactionid = ?";

	private static final String CANCEL_SUBSCRIPTION = "UPDATE `appdirect`.`tbl_substransaction` set transstatus=? WHERE transactionid = ?";

	private static final Logger LOG = Logger.getLogger(SubscriptionDaoImpl.class);

	@Override
	public boolean insert(SubscriptionTransaction transObj) {
		boolean flag = false;
		try {
			transObj.setTransactionid(AppdirectUtils.nextUUID());
			getJdbcTemplate().update(INSERT_SUBSCRIPTION,
					new Object[]{transObj.getTransactionid(), transObj.getUserAction(), transObj.getTransStatus(), transObj.getProductPrice(),
							transObj.getChargePrice(), transObj.getMode(), transObj.getServiceName(), transObj.getChannelName(),
							transObj.getSegment()});
			flag = true;
		} catch (DataAccessException e) {
			LOG.error(e);
		}
		return flag;

	}
	@Override
	public boolean update(SubscriptionTransaction transObj) {
		boolean flag = false;
		try {
			getJdbcTemplate().update(UPDATE_SUBSCRIPTION,
					new Object[]{transObj.getUserAction(), transObj.getTransStatus(), transObj.getProductPrice(), transObj.getChargePrice(),
							transObj.getMode(), transObj.getServiceName(), transObj.getChannelName(), transObj.getSegment(),
							transObj.getTransactionid()});
			flag = true;
		} catch (DataAccessException e) {
			LOG.error(e);
		}
		return flag;
	}

	@Override
	public boolean cancel(String transactionId) {
		boolean flag = false;
		try {
			getJdbcTemplate().update(CANCEL_SUBSCRIPTION, new Object[]{SubscriptionStatus.CANCELLED.getStatusCode(), transactionId});
			flag = true;
		} catch (DataAccessException e) {
			LOG.error(e);
		}
		return flag;
	}

	@Override
	public SubscriptionTransaction get(final String transactionId) {

		return getJdbcTemplate().queryForObject(SELECT_SUBSCRIPTION, new Object[]{transactionId}, new RowMapper<SubscriptionTransaction>() {

			@Override
			public SubscriptionTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
				SubscriptionTransaction subscriptionTransaction = new SubscriptionTransaction();
				subscriptionTransaction.setTransactionid(transactionId);
				subscriptionTransaction.setTransDate(AppdirectUtils.mysqlDateToUtilDate(rs.getTimestamp("transdate")));
				subscriptionTransaction.setUserAction(rs.getInt("useraction"));
				subscriptionTransaction.setTransStatus(rs.getInt("transstatus"));
				subscriptionTransaction.setProductPrice(rs.getDouble("productprice"));
				subscriptionTransaction.setChargePrice(rs.getDouble("chargeprice"));
				subscriptionTransaction.setMode(rs.getString("mode"));
				subscriptionTransaction.setServiceName(rs.getString("servicename"));
				subscriptionTransaction.setChannelName(rs.getString("channelname"));
				subscriptionTransaction.setSegment(rs.getString("segment"));
				subscriptionTransaction.setUpdateon(AppdirectUtils.mysqlDateToUtilDate(rs.getTimestamp("updateon")));

				return subscriptionTransaction;
			}
		});

	}
}
