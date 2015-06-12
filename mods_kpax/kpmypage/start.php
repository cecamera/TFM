<?php 
/** 
* Plugin that creates a menu entry to the personal page
* It adds new default profile fields and
* modifies the personal profile page as well
*/ 

elgg_register_event_handler('init', 'system', 'kpmypage_init'); 

function kpmypage_init() { 

  elgg_register_plugin_hook_handler('profile:fields', 'profile', 'get_kpax_default_profile_fields');

  elgg_register_page_handler('mypage', 'kpmypage_page_handler');

  elgg_register_menu_item('site', array(
    'name' => 'mypage',
    'text' => elgg_echo('mypage'),
    'href' => 'mypage'
  ));

 // both register the JavaScript file and tell Elgg to load it on every page
  $url = 'mod/kpmypage/vendors/jquery_tools/jquery.tools.min.js';
  elgg_register_js('jquery.tools', $url, 'footer');
  elgg_load_js('jquery.tools');

  // add our custom CSS and the JavaScript we need to initialize the tooltips
  elgg_extend_view('js/elgg', 'tooltips/js');
  elgg_extend_view('css/elgg', 'tooltips/css');

}  

function kpmypage_page_handler($page, $identifier) {
  if ($identifier ='mypage'){
    $user = elgg_get_logged_in_user_entity();
    $username = $user->username;
    forward("pg/profile/".$username);
  }
  return true; 
}

function get_kpax_default_profile_fields() {
  $kpax_profile_defaults = array (
    'description' => 'longtext',
    'briefdescription' => 'text',
    'location' => 'text',
    'zipcode' => 'text', // new!!
    'country' => 'text', // new!!
    'birthdate' => 'date', // new!!
    'interests' => 'tags',
    'skills' => 'tags',
    'contactemail' => 'email',
    'phone' => 'text',
    'mobile' => 'text',
    'website' => 'url',
    'twitter' => 'text',
    'signaturequote' => 'text' // new!!
  );
  return $kpax_profile_defaults;
}



