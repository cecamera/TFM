<?php 
/** 
* Widget edit code 
* User selects the maxim number of abilities
*/ 

// set default value 
if (!isset($vars['entity']->numberAbilities)) { 
  $vars['entity']->numberAbilities = 1; 
}

// when Elgg handles the saving, names need to be params[<var name>] 
$params = array( 
  'name' => 'params[numberAbilities]', 
  'value' => $vars['entity']->numberAbilities, 
  'options' => array(1, 2, 3, 4, 5, 6, 7, 99), 
); 

// create a dropdown list with the $params array
$dropdown = elgg_view('input/dropdown', $params); 
?> 

<div> 
  <?php echo elgg_echo('kpmyabilities:choice_number_abilities'); ?>: 
  <?php echo $dropdown; ?> 
</div>
 
