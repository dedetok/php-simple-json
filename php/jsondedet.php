<?php 

class JSONDEDET {
	private $mysignature = array(
		"application_name" => "testing",
		"version" => "0.1");
	private $myresponse = array(
		"response_code"=>"200", 
		"response_msg"=>"OK");
	private $data = array();
	
	private $myresult = array();

	function __construct() {
		$this->myresult["dedetok"] = $this->mysignature;
		$this->myresult["response"] = $this->myresponse;
	}

	function setResponse($myresponse_code, $myresponse_msg) {
		$this->myresponse["response_code"]= $myresponse_code;
		$this->myresponse["response_msg"]= $myresponse_msg;
		$this->myresult["response"] = $this->myresponse;
	}

	function setData($data) {
		$this->data = $data;
		$this->myresult["data"] = $this->data;
	}
	
	function toJSON() {
			return json_encode($this->myresult);
	}
}

?>
