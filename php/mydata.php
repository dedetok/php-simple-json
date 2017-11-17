<?php 
/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
if (!defined("JSONDEDET")) die("Can not access directly");

class MyData {
	public $myData = array (
		"Paint" => array (
			"Vinilex" => array(
				"quantity" => 10,
				"Price" => 200000),
			"Manatex" => array(
				"quantity" => 15,
				"Price" => 120000),
			"QLux" => array(
				"quantity" => 55,
				"Price" => 100000)
			),
		"Roll" => array (
			"Supra" => array(
				"quantity" => 10,
				"Price" => 50000),
			"Supra Refill" => array(
				"quantity" => 10,
				"Price" => 25000)
			),
		"Cement" => array (
			"Tiga Roda" => array(
				"quantity" => 10,
				"Price" => 75000),
			"Gresik" => array(
				"quantity" => 10,
				"Price" => 75000)
			)
		);			
}
?>
