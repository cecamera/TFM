<?php 
/** 
* kpmybadges widget plugin 
*/ 

elgg_register_event_handler('init', 'system', 'kpmybadges_widget_init');
   
function kpmybadges_widget_init() { 

  // initialize the widget
  $title = elgg_echo('kpmybadges:title'); 
  $description = elgg_echo('kpmybadges:widget:description'); 
  elgg_register_widget_type('kpmybadges', $title, $description);

  // register the kpaxSrv library
  $lib = elgg_get_plugins_path() . '/kpax/lib/kpaxSrv.php';
  elgg_register_library('kpaxSrv', $lib);
  elgg_load_library('kpaxSrv');

} 
