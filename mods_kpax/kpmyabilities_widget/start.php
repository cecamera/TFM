<?php 
/** 
* kpmyabilities widget plugin 
*/ 

elgg_register_event_handler('init', 'system', 'kpmyabilities_widget_init');
   
function kpmyabilities_widget_init() { 
  // initialize the widget
  $title = elgg_echo('kpmyabilities:title'); 
  $description = elgg_echo('kpmyabilities:widget:description'); 
  elgg_register_widget_type('kpmyabilities', $title, $description);
 
  // register the kpaxSrv library
  $lib = elgg_get_plugins_path() . '/kpax/lib/kpaxSrv.php';
  elgg_register_library('kpaxSrv', $lib);
  elgg_load_library('kpaxSrv');
} 
