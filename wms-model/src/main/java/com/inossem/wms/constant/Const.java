package com.inossem.wms.constant;


import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Const {
	//二维码颜色
	public static final int QRCODE_COLOR_BLACK = 0xFF000000;
	public static final int QRCODE_COLOR_WHITE = 0xFFFFFFFF;
		
	public static final DateTimeFormatter MATTER_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final DateTimeFormatter MATTER_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static final DateTimeFormatter MATTER_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static final DateTimeFormatter FORMATTER_DATETIME1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter FORMATTER_DATETIME2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	public static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static final DateTimeFormatter FORMATTER_TIME_MINUTE = DateTimeFormatter.ofPattern("HH:mm");
	public static final DateTimeFormatter FORMATTER_DATE1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final DateTimeFormatter FORMATTER_DATE2 = DateTimeFormatter.ofPattern("yyyyMMdd");
	public static final DateTimeFormatter FORMATTER_DATE3 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	public static final DateTimeFormatter FORMATTER_MONTH = DateTimeFormatter.ofPattern("yyyy-MM");
    
	public static final String SINOBEC_MASK_WEIGHT_UNIT_CODE = "BOX";
	
	public static final String SINOBEC_MASK_RECEIPT_UNIT_CODE = "PCS";
	
	
	
	
	
	public static final Set<String> SINOBEC_MASK_MAT_CODE_SET = new HashSet<String>() {
		
		
		private static final long serialVersionUID = -975313921035016411L;

		{
			// 文件类
			add("OT990001");
			add("OT990002");
			add("OT990003");
			add("OT990004");
			
		}
	};
	
	public static final String SINOBEC_MASK_TYPE_CODE = "MASK";
	
	
	
	
	public static final String HORIZONTAL_LINE = "-";
	
	public static final String LEFT_SLASH_LINE = "/";
	
	public static final String SEMICOLON = ";";
	
	public static final String DOUBLE_SLASH_LINE = "\\";
	
	public static final String STRING_SEPRATE_FLAG = "#";
	
	public static final String SEQUENCE_FTY_PREFIX = "fty_";
	
	public static final String DOUBLE_SPLIT_CODE = "%s/%s";
	
	public static final String DOUBLE_CODE = "%s-%s";

	public static final String THREE_CODE = "%s-%s-%s";

	public static final String THREE_STRING_FORMAT = "%s%s%s";

	public static final String STRING_EMPTY = "";
	public static final String STRING_NULL = "null";
	public static final int NEGATIVE = -1;

	public static final int ZERO = 0;

	public static final String PARENTHESES_LEFT = "(";
	public static final String PARENTHESES_RIGHT = ")";
	public static final String SQUARE_BRACKETS_LEFT = "[";
	public static final String SQUARE_BRACKETS_RIGHT = "]";
	public static final String BRACE_LEFT = "{";
	public static final String BRACE_RIGHT = "}";
	
	//public static final String CONDITION_TYPE_SMALL_SYMBOL_BY_HTML = "&lt;";
	//public static final String CONDITION_TYPE_BIG_SYMBOL_BY_HTML = "&gt;";
	public static final String CONDITION_TYPE_SMALL_SYMBOL_BY_HTML = "<";
	public static final String CONDITION_TYPE_BIG_SYMBOL_BY_HTML = ">";
	
	public static final String PUSH_MESSAGE_WF = "push_message_wf";
	public static final String PUSH_MESSAGE_ACTOR = "push_message_actor";
	public static final String PUSH_MESSAGE_TASK = "push_message_task";
	public static final String PUSH_MESSAGE_WEB_TASK = "push_message_web_task";
	public static final String PUSH_MESSAGE_ANDROID_TASK = "push_message_android_task";
	
	/** ipas token 时间戳*/
	public static final String CACHE_IPAS_TOKEN = "ipas_token";
	
	public static final String CACHE_CORP = "corp";
	public static final String CACHE_FACTORY = "factory";
	public static final String CACHE_LOCATION = "location";
	public static final String CACHE_BATCHERP = "batcherp";
	public static final String CACHE_WH = "wh";
	public static final String CACHE_SECTION = "section";
	public static final String CACHE_STORAGE_TYPE = "type";
	public static final String CACHE_BIN = "bin";
	public static final String CACHE_UNIT = "unit";
	public static final String CACHE_RELUNIT = "relunit";
	public static final String CACHE_LANGUAGE = "language";
	public static final String CACHE_LANGUAGE_I18N_TEXT = "language_i18n_text";
	public static final String CACHE_DICMATERIALFACTORY = "dicMaterialFactory";
	public static final String CACHE_BUFFACTORYMATPRICE = "bufFactoryMatPrice";
	public static final String CACHE_MATERIAL = "material";
	public static final String CACHE_MATERIAL_I18N_NAME = "material_i18n_text";
	public static final String RETURN_CODE = "return_code";
	public static final String RETURN_MSG = "return_msg";
	public static final String BODY = "body";
	public static final String I18N_ = "i18n_";
	public static final String _MID = "_mid";
	public static final String _TID = "_tid";
	public static final String _MSG = "_msg";
	public static final String _NAME = "_name";
	public static final String NAME = "Name";
	public static final String ECEIPT_TYPE = "eceiptType";
	public static final String ECEIPT_SUB_TYPE = "eceiptSubType";
	public static final String STATUS = "Status";
	public static final String OPERATION_TYPE = "OperationType";
	public static final String STRING_ZERO = "0";
	public static final String STRING_ONE = "1";
	public static final String STRING_TWO = "2";
	public static final String STRING_THREE = "3";
	public static final String STRING_FOUR = "4";

	public static final String TEXT_MESSAGES = "messages/text_messages_";
	public static final String RETURN_CODE_MESSAGES = "messages/return_code_messages_";
	public static final String NAME_MESSAGE = "messages/name_messages_";

	public static final String UNDERLINE = "_";
	public static final char UNDERLINE_CHAR = '_'; 
	public static final String INITIAL_PASSWORD = "123456";
	public static final String RESETT_PASSWORD = "654321";
	public static final String COMMA = ",";
	
	public static final String DEFAULT_LANG_CODE = "en-US";
	public static final String LANG_CODE = "langCode";
	public static final String LANG_CODE_HEADER_NAME = "lang_code";
	public static final String CURRENT_USER = "currentUser";
	
	public static final String COMPRESS = "compress";
	
	public static final String UN_COMPRESS = "0";
	
	public static final String EN_COMPRESS = "1";
	
	public static final String CONF_ACTOR_RECEIPT_TYPE = "actor";
	
	public static final String CONF_WF_RECEIPT_TYPE = "wf";
	
	
	
	public static final String QUEUE_LISTENER_CONTAINER = "queueListenerContainer";
	public static final String TOPIC_LISTENER_CONTAINER = "topicListenerContainer";
	
	/* **************log4j2 logger names start ************ */
	public static final String LOGGER_NAME_SAP_REST_API= "sapRestApi";
	public static final String LOGGER_NAME_OUTPUT= "output";
	public static final String LOGGER_NAME_ACTIVE_MQ= "activeMQ";
	public static final String LOGGER_NAME_LOGIN_LOG = "login_log";
	public static final String LOGGER_NAME_SAP_LOG = "sap_log";
	public static final String LOGGER_NAME_EXCEPTION_LOG = "exception_log";
	/* **************log4j2 logger names end ************ */
	
	public static final Set<String> ALLOWED_UPLOAD_FILE_EXTENSION_SET = new HashSet<String>() {
		private static final long serialVersionUID = 7068423596064433196L;
		{
			// 文件类
			add("txt");
			add("doc");
			add("docx");
			add("els");
			add("elsx");
			add("ppt");
			add("pptx");
			// 图片类
			add("bmp");
			add("jpg");
			add("jpeg");
			add("png");
			add("gif");
			add("svg");
			add("webp");
			add("ico");
			// 压缩文件
			add("zip");
			add("rar");
			add("7z");
			add("tar");
			add("gz");
			// 安装文件
			add("apk");
		}
	};
	
	/**
	 * 分页使用参数
	 */
	public static final String PAGE_ASC= "asc";
	
	
	
	/**
	 * 冻结原因
	 */
	public static final String FREEZE_REASON = "盘点仓位冻结";
	
	public static final String ERP_RETURN_TYPE_S = "S";
	public static final String ERP_RETURN_TYPE_E = "E";
	
	

	
	
	
	/**
	 * 根据前续单据号删除作业请求
	 */
	public static final String DELETE_REQ_BY_PRE_RECEIPT_CODE = "delete_req_by_pre_receipt_code";
	
	/**
	 * 生成审批请求
	 */
	public static final String START_APPROVAL_REQUEST_CODE = "start_approval_request_code";
	
	/**
	 * 生成经办请求
	 */
	public static final String START_ACTOR_REQUEST_CODE = "start_actor_request_code";
	
	
	
	
	/**
	 * 返回成功的文字说明
	 */
	public static final String SUCCESS_MESSAGE = "success_message";

	/**
	 * 返回失败的文字说明
	 */
	public static final String FAILED_MESSAGE = "failed_message";
	/******************* 分页及时间及结果集key常量start ******************/
	public static final String PAGE_INDEX_KEY = "pageIndex";
	
	public static final String PAGE_SIZE_KEY = "pageSize";
	
	public static final String CREATE_DATE_KEY = "createDate";
	
	public static final String END_DATE_KEY = "endDate";
	
	public static final String CREATE_TIME_KEY = "createTime";
	
	public static final String RESULT_KEY = "result";
	
	public static final String TOTAL_KEY = "total";
	/******************* 分页及时间及结果集key常量end ******************/
	
}
