package com.inossem.wms.common.util;

import static com.alibaba.fastjson.JSON.toJSONString;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * 改造自开源代码westjson，将json数据的结构转换，节省存储空间
 * @author libin
 * 2019年5月28日
 * @see https://github.com/bingoohuang/westjson
 */
public class UtilJsonCompactor {

	/*
	 * 启用浓缩模式。 比如[{c:d1,d:1},{c:d2,d:2},{c:d3,d:3}]
	 * 浓缩{_h:[c,d],_d:[d1,1,d2,2,d3,3]}
	 *
	 */
	public static final int COMPACT = 0x01;

	public static String json(String json) {
		return json(json, COMPACT);
	}

	public static String json(String json, int flags) {
		Object object = JSON.parse(json);
		return json(object, flags);
	}

	public static String json(Object bean) {
		return json(bean, COMPACT);
	}

	public static String json(Object bean, int flags) {
		String compacted = makeCompact(toJSONString(bean), flags & COMPACT);

		return compacted;
	}

	private static String makeCompact(String str, int compactFlag) {
		if (compactFlag == 0)
			return str;

		JSON json = (JSON) JSON.parse(str);
		JSON compacted = JsonCompacter.compact(json);
		return toJSONString(compacted);
	}

	public static JSON parse(String jsonStr) {
		return parse(jsonStr, COMPACT);
	}

	public static JSON parse(String jsonStr, int flags) {
		try {
			JSON json = JsonUtils.parseJSON(jsonStr);
			JSON uncompacted = (flags & COMPACT) > 0 ? JsonUncompacter.uncompact(json) : json;
			return uncompacted;
		} catch (Throwable e) {
			throw new RuntimeException("parse error:" + jsonStr, e);
		}
	}

	public <T> T parse(String jsonStr, Class<T> tClass) {
		return parse(jsonStr).toJavaObject(tClass);
	}

//	public static void main(String[] args) {
//		String s = "{\"currentUserId\":1,\"itemList\":[{\"batchErp\":\"E100000086\",\"batchInspection\":\"\",\"batchProduction\":\"\",\"batchSupplier\":\"\",\"contractCode\":\"3256000001\",\"contractName\":\"\",\"createTime\":1544856263958,\"createUserId\":1,\"customerCode\":\"30001\",\"customerName\":\"客户1\",\"debtOffset\":0,\"deliveryOutwardCode\":\"\",\"deliveryOutwardCreateUserName\":\"\",\"deliveryOutwardRid\":\"\",\"demandQty\":200.000,\"docDate\":1544856098000,\"ftyCode\":\"9000\",\"inspection\":0,\"isDelete\":0,\"itemInfoList\":[{\"batch\":\"201811270011\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"02-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":2.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":62,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270012\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"02-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":63,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270013\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"03-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0003\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":64,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270013\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"03-01-02\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0003\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":65,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"04-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":66,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"04-01-02\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":67,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270010\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"00\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0001\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":68,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"800\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"00\",\"createTime\":1544443022000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":69,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"804\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270011\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"02-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":70,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270012\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"02-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":71,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270013\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"03-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0003\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":72,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270013\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"03-01-02\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0003\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":73,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"04-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":74,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"04-01-02\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":75,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270010\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"00\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0001\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":76,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"800\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"00\",\"createTime\":1544443022000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":77,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"804\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270011\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"02-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":78,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270012\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"02-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":79,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270013\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"03-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0003\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":80,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270013\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"03-01-02\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0003\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":81,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"04-01-01\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":82,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"04-01-02\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":83,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"001\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270010\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"00\",\"createTime\":1543301251000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0001\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":84,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"800\",\"unitCode\":\"KG\",\"whCode\":\"\"},{\"batch\":\"201811270014\",\"batchErp\":\"E100000086\",\"batchProduction\":\"\",\"binCode\":\"00\",\"createTime\":1544443022000,\"createUserId\":1,\"ftyCode\":\"9000\",\"isDelete\":0,\"locationCode\":\"0004\",\"matCode\":\"41000000002\",\"modifyTime\":1557105976084,\"modifyUserId\":1,\"operatedQty\":0.000,\"packageType\":\"\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputBid\":\"\",\"stockOutputBinExt0\":\"\",\"stockOutputBinExt1\":\"\",\"stockOutputBinExt2\":\"\",\"stockOutputBinExt3\":\"\",\"stockOutputBinExt4\":\"\",\"stockOutputBinExt5\":\"\",\"stockOutputBinExt6\":\"\",\"stockOutputBinExt7\":\"\",\"stockOutputBinExt8\":\"\",\"stockOutputBinExt9\":\"\",\"stockOutputBinId\":85,\"stockOutputCode\":\"CK00000057\",\"stockOutputRid\":\"1\",\"stockType\":10,\"taskQty\":0.000,\"typeCode\":\"804\",\"unitCode\":\"KG\",\"whCode\":\"\"}],\"itemStatus\":10,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"matDocCode\":\"\",\"matDocRid\":\"\",\"matDocYear\":\"\",\"matReqCode\":\"\",\"matReqCreateUserName\":\"\",\"matReqRid\":\"\",\"modifyTime\":1554274048858,\"modifyUserId\":1,\"money\":1000.000,\"moveTypeCode\":\"\",\"moveTypeName\":\"\",\"moveTypeSpecStock\":\"\",\"mrpController\":\"\",\"mrpRange\":\"\",\"operatedQty\":0.000,\"packageType\":\"\",\"postingDate\":1544856098000,\"preReceiptCode\":\"6100000001\",\"preReceiptRid\":\"0001\",\"preReceiptType\":4110,\"purchaseGroupCode\":\"\",\"purchaseGroupName\":\"\",\"purchaseOrganizationCode\":\"\",\"purchaseOrganizationName\":\"\",\"purchaseReceiptCode\":\"\",\"purchaseReceiptCreateUserName\":\"\",\"purchaseReceiptRid\":\"\",\"purchaseReceiptType\":\"\",\"purchaseReceiptTypeName\":\"\",\"receiptStatus\":10,\"receiptSubType\":4110,\"receiptType\":411,\"receivingPartyCode\":\"\",\"receivingPartyName\":\"\",\"remark\":\"\",\"requestSource\":0,\"reserveCode\":\"\",\"reserveCostCenterCode\":\"\",\"reserveCostCenterName\":\"\",\"reserveCostObjCode\":\"\",\"reserveCostObjName\":\"\",\"reserveCreateUser\":\"\",\"reserveRid\":\"\",\"saleOrganizationCode\":\"\",\"saleOrganizationName\":\"\",\"saleReceiptCode\":\"6100000001\",\"saleReceiptCreateUserName\":\"\",\"saleReceiptRid\":\"0001\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputCode\":\"CK00000057\",\"stockOutputExt0\":\"\",\"stockOutputExt1\":\"\",\"stockOutputExt2\":\"\",\"stockOutputExt3\":\"\",\"stockOutputExt4\":\"\",\"stockOutputExt5\":\"\",\"stockOutputExt6\":\"\",\"stockOutputExt7\":\"\",\"stockOutputExt8\":\"\",\"stockOutputExt9\":\"\",\"stockOutputId\":51,\"stockOutputRid\":\"1\",\"supplierCode\":\"\",\"supplierName\":\"\",\"taskQty\":0.000,\"unitCode\":\"KG\",\"wfId\":\"\",\"writeOff\":0,\"writeOffMatDocCode\":\"\",\"writeOffMatDocRid\":\"\",\"writeOffMatDocYear\":\"\"},{\"batchErp\":\"E100000086\",\"batchInspection\":\"\",\"batchProduction\":\"\",\"batchSupplier\":\"\",\"contractCode\":\"3256000001\",\"contractName\":\"\",\"createTime\":1544856265401,\"createUserId\":1,\"customerCode\":\"30001\",\"customerName\":\"客户1\",\"debtOffset\":0,\"deliveryOutwardCode\":\"\",\"deliveryOutwardCreateUserName\":\"\",\"deliveryOutwardRid\":\"\",\"demandQty\":200.000,\"docDate\":1544856098000,\"ftyCode\":\"9000\",\"inspection\":0,\"isDelete\":0,\"itemInfoList\":[],\"itemStatus\":10,\"locationCode\":\"0002\",\"matCode\":\"41000000002\",\"matDocCode\":\"\",\"matDocRid\":\"\",\"matDocYear\":\"\",\"matReqCode\":\"\",\"matReqCreateUserName\":\"\",\"matReqRid\":\"\",\"modifyTime\":1554274048858,\"modifyUserId\":1,\"money\":1000.000,\"moveTypeCode\":\"\",\"moveTypeName\":\"\",\"moveTypeSpecStock\":\"\",\"mrpController\":\"\",\"mrpRange\":\"\",\"operatedQty\":0.000,\"packageType\":\"\",\"postingDate\":1544856098000,\"preReceiptCode\":\"6100000001\",\"preReceiptRid\":\"0002\",\"preReceiptType\":4110,\"purchaseGroupCode\":\"\",\"purchaseGroupName\":\"\",\"purchaseOrganizationCode\":\"\",\"purchaseOrganizationName\":\"\",\"purchaseReceiptCode\":\"\",\"purchaseReceiptCreateUserName\":\"\",\"purchaseReceiptRid\":\"\",\"purchaseReceiptType\":\"\",\"purchaseReceiptTypeName\":\"\",\"receiptStatus\":10,\"receiptSubType\":4110,\"receiptType\":411,\"receivingPartyCode\":\"\",\"receivingPartyName\":\"\",\"remark\":\"\",\"requestSource\":0,\"reserveCode\":\"\",\"reserveCostCenterCode\":\"\",\"reserveCostCenterName\":\"\",\"reserveCostObjCode\":\"\",\"reserveCostObjName\":\"\",\"reserveCreateUser\":\"\",\"reserveRid\":\"\",\"saleOrganizationCode\":\"\",\"saleOrganizationName\":\"\",\"saleReceiptCode\":\"6100000001\",\"saleReceiptCreateUserName\":\"\",\"saleReceiptRid\":\"0002\",\"specStock\":\"\",\"specStockCode\":\"\",\"specStockName\":\"\",\"stockOutputCode\":\"CK00000057\",\"stockOutputExt0\":\"\",\"stockOutputExt1\":\"\",\"stockOutputExt2\":\"\",\"stockOutputExt3\":\"\",\"stockOutputExt4\":\"\",\"stockOutputExt5\":\"\",\"stockOutputExt6\":\"\",\"stockOutputExt7\":\"\",\"stockOutputExt8\":\"\",\"stockOutputExt9\":\"\",\"stockOutputId\":52,\"stockOutputRid\":\"2\",\"supplierCode\":\"\",\"supplierName\":\"\",\"taskQty\":0.000,\"unitCode\":\"KG\",\"wfId\":\"\",\"writeOff\":0,\"writeOffMatDocCode\":\"\",\"writeOffMatDocRid\":\"\",\"writeOffMatDocYear\":\"\"}],\"receiptRemark\":\"remark123\"}";
//		String sjson = UtilJsonCompactor.json(s);
//		System.out.println("压缩后json：" + sjson);
//		String ujson = UtilJsonCompactor.parse(sjson).toJSONString();
//		System.out.println("解压后json：" + ujson);
//	}

	private static class JsonCompacter {
		public static JSON compact(JSON object) {
			JSON result = object;
			if (object instanceof JSONObject) {
				result = compactConvert((JSONObject) object);
			} else if (object instanceof JSONArray) {
				result = compactConvert((JSONArray) object);
			}
			return result;
		}

		private static JSONObject compactConvert(JSONObject jsonObject) {
			JSONObject compactJsonObject = new JSONObject();
			for (Entry<String, Object> entry : jsonObject.entrySet()) {
				Object value = entry.getValue();
				if (value instanceof JSONArray) {
					value = compactConvert((JSONArray) value);
				} else if (value instanceof JSONObject) {
					value = compactConvert((JSONObject) value);
				}
				compactJsonObject.put(entry.getKey(), value);
			}
			return compactJsonObject;
		}

		private static JSON compactConvert(JSONArray value) {
			if (value == null || value.size() == 0)
				return value;
			JSONObject compactObject = new JSONObject();
			JSONArray header = null;
			JSONArray data = null;
			int lineNo = 0;
			int arraySize = value.size();

			for (Object item : value) {
				++lineNo;
				if (!(item instanceof JSONObject))
					return value; // 不转换
				JSONObject objItem = (JSONObject) item;
				if (lineNo == 1) {
					header = new JSONArray();
					if (arraySize == 1) {
						header.add(compact(objItem));
						return header;
					}

					data = new JSONArray();
					Set<String> headSet = new TreeSet<String>();
					for (String key : objItem.keySet()) {
						headSet.add(key);
					}

					for (String head : headSet) {
						header.add(head);
						if (objItem.get(head) instanceof JSONArray) {
							data.add(compactConvert((JSONArray) objItem.get(head)));
						} else {
							data.add(objItem.get(head));
						}
					}
					continue;
				}

				if (!hasSameColumns(header, objItem))
					return value;

				for (Object key : header) {
					data.add(objItem.get(key));
				}
			}

			compactObject.put("_h", header);
			compactObject.put("_d", data);

			return compactObject;
		}

		private static boolean hasSameColumns(JSONArray header, JSONObject objItem) {
			if (objItem.size() != header.size())
				return false;

			for (String obj : objItem.keySet())
				if (!header.contains(obj))
					return false;

			return true;
		}
	}

	private static class JsonUncompacter {
		public static JSON uncompact(JSON object) {
			JSON result = object;
			if (object instanceof JSONObject) {
				result = uncompact((JSONObject) object);
			} else if (object instanceof JSONArray) {
				result = uncompact((JSONArray) object);
			}

			return result;
		}

		private static JSON uncompact(JSONObject object) {
			if (isCompactedArrayFormat(object)) {
				return uncompactArrayFormat(object);
			}

			JSONObject uncompacted = new JSONObject();
			for (Entry<String, Object> item : object.entrySet()) {
				Object value = item.getValue();

				Object val = value instanceof JSON ? uncompact((JSON) value) : value;
				uncompacted.put(item.getKey(), val);
			}

			return uncompacted;
		}

		private static JSONArray uncompact(JSONArray arr) {
			JSONArray uncompacted = new JSONArray(arr.size());
			for (Object item : arr) {
				Object obj = item instanceof JSON ? uncompact((JSON) item) : item;
				uncompacted.add(obj);
			}

			return uncompacted;
		}

		private static boolean isCompactedArrayFormat(JSONObject object) {
			return object.size() == 2 && object.containsKey("_h") && object.containsKey("_d");
		}

		private static JSONArray uncompactArrayFormat(JSONObject jsonValue) {
			JSONArray head = jsonValue.getJSONArray("_h");
			JSONArray data = jsonValue.getJSONArray("_d");
			int arraySize = data.size() / head.size();
			JSONArray uncompacted = new JSONArray(arraySize);
			for (int i = 0; i < arraySize; i++) {
				JSONObject item = new JSONObject(head.size());
				uncompacted.add(item);

				for (int j = 0, jj = head.size(); j < jj; ++j) {
					if (data.get(i * jj + j) instanceof JSONObject
							&& isCompactedArrayFormat((JSONObject) data.get(i * jj + j))) {
						item.put(head.getString(j), uncompactArrayFormat((JSONObject) data.get(i * jj + j)));
					} else {
						item.put(head.getString(j), data.get(i * jj + j));
					}
				}
			}

			return uncompacted;
		}

	}

}

abstract class JsonUtils {
	public static boolean isNumeric(String str) {
		return str != null && str.length() > 0 && str.matches("[+-]?\\d*(\\.\\d+)?");
	}

	public static boolean isMeta(char ch) {
		return ch == ',' || ch == ':' || isBoundary(ch);
	}

	public static boolean isBoundary(char p) {
		return isRBoundary(p) || isLBoundary(p);
	}

	public static boolean isLBoundary(char p) {
		return p == '{' || p == '[';
	}

	public static boolean isRBoundary(char p) {
		return p == '}' || p == ']';
	}

	public static boolean isRKey(String json, int i, int ii) {
		return isRTrue(json, i, ii) && isSep(json, i, ii, 5) || isRFalse(json, i, ii) && isSep(json, i, ii, 6)
				|| isRNull(json, i, ii) && isSep(json, i, ii, 5);
	}

	private static boolean isSep(String json, int i, int ii, int offset) {
		if (i + offset >= ii)
			return true;

		return isMeta(json.charAt(i + offset));
	}

	public static boolean isLKey(String json, int i, int ii) {
		return isRTrue(json, i - 5, ii) && isSep(json, i, ii, -5) || isRFalse(json, i - 6, ii) && isSep(json, i, ii, -6)
				|| isRNull(json, i - 5, ii) && isSep(json, i, ii, -5);
	}

	public static boolean isRTrue(String json, int i, int ii) {
		return i >= 0 && ii - i > 4 && json.charAt(i + 1) == 't' && json.charAt(i + 2) == 'r'
				&& json.charAt(i + 3) == 'u' && json.charAt(i + 4) == 'e';
	}

	public static boolean isRFalse(String json, int i, int ii) {
		return i >= 0 && ii - i > 5 && json.charAt(i + 1) == 'f' && json.charAt(i + 2) == 'a'
				&& json.charAt(i + 3) == 'l' && json.charAt(i + 4) == 's' && json.charAt(i + 5) == 'e';
	}

	public static boolean isRNull(String json, int i, int ii) {
		return i >= 0 && ii - i > 4 && json.charAt(i + 1) == 'n' && json.charAt(i + 2) == 'u'
				&& json.charAt(i + 3) == 'l' && json.charAt(i + 4) == 'l';
	}

	public static int bytesLen(String strValue) {
		return strValue.getBytes(Charset.forName("UTF-8")).length;
	}

	public static <K, V> Map<V, K> invert(Map<K, V> source) {
		Map<V, K> reversedMap = new HashMap<V, K>(source.size());
		for (Map.Entry<K, V> entry : source.entrySet())
			reversedMap.put(entry.getValue(), entry.getKey());

		return reversedMap;
	}

	public static JSON parseJSON(String json) {
		try {
			return (JSON) JSON.parse(json);
		} catch (Throwable e) {
			throw new RuntimeException("JSON:" + json, e);
		}
	}

	static ValueFilter filter = new ValueFilter() {
		@Override
		public Object process(Object source, String name, Object value) {
			if (value instanceof Number)
				return String.valueOf(value);
			return value;
		}
	};

	public static String convertNumberToString(String raw) {
		Object parse = JSON.parse(raw);
		return JSON.toJSONString(parse, new SerializeFilter[] { filter }, WriteMapNullValue);
	}
}
