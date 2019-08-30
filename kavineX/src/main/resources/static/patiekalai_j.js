	$(document).ready ( function() {
			
		var id_accessing;
		var id_add_pat;
		var patiekalo_id;
		var ingred_id;
		var ingred_pav;
						
		pasiimtiPatiekalus();
		
		function del_pat( id ) {
		
			params_str = 'id=' + id;  
		
			$.ajax(
				{
					url: "http://localhost:8080/restfull/del_pat?" + params_str
				}
			)
			.done( function( data ) {
				
				pasiimtiPatiekalus();
			});			
		}
		
		function pasiimtiPatiekalus() {
		
			$.ajax(
				{
					url: "http://localhost:8080/restfull/all_pat" 
															
				})
			
			.done(	function( data ) {
															
				res_str = '<table class="t">'
					+ '<tr><th rowspan="2">ID</th><th rowspan="2">Pavadinimas</th><th colspan="2">TRUKMĖ</th></tr>'
					+ '<tr><th>ruošimo</th><th>kaitinimo</th><th>Kaina</th></tr>';
						
				for ( i = 0; i < data.length; i++) {
						
					res_str += '<tr class="s' + data [ i ].busena  + '" data-id="' + data [ i ].id  +'" >'
						+ '<td>' + data [ i ].id + '</td>' 
						+ '<td>' + data [ i ].pav + '</td>'
						+ '<td>' + data [ i ].trukme_ruosimo + '</td>'
						+ '<td>' + data [ i ].trukme_kaitinimo + '</td>'
						+ '<td>' + data [ i ].kaina + '</td>';
								
					res_str +=
						'<td><input type="button" class="istrinti" value="Ištrinti"></td>'
						+ '<td><input type="button" class="sudetis" value="Sudėtis"></td>'
									
					res_str += '</tr>';
											
				}
						
				res_str += '</table>'
				
					$( '#uzsakymai' ).html ( res_str );
						
					$( '.istrinti' ).on ( 'click', function() {
						
						$( this ).each ( function() {
								
							id_accessing = $( this ).parent( ).parent().data ( 'id' );
							ConfirmDialog('Ar tikrai nori ištrinti?');
								
						});
					});
					
					$( ".sudetis" ).on ( "click", function() {
			
						patiekalo_id = $( this ).parent().parent().data( 'id' );
			
						pat_sudetis();
			
					});				
				
				
			});
								
		}
		
		
		
		function pat_sudetis() {
			
			$.ajax(
					{
						url: "http://localhost:8080/restfull/patiekalai?patiekalo_id="  + patiekalo_id 
															
					})
							
						.done(	function( data ) {
									
							$( "#sudetis" ).dialog( "open" );
								
							patiekalas = data; 
											
							i=0;
							
							ingredientai = '<table tfoot class="ui-widget-header">' + '<tr><th>Pavadinimas</th><th>Kiekis</th></tr>';
										
							while (i < patiekalas.patiekalu_produktai.length) {
											
								ingredientai += 
								 '<tr data-id="' + patiekalas.patiekalu_produktai [ i ].id + '" data-pav="' + patiekalas.patiekalu_produktai [ i ].produktai.pav + '" data-kiekis="' + patiekalas.patiekalu_produktai [ i ].kiekis + '"><td>' + patiekalas.patiekalu_produktai[i].produktai.pav + '</td>'
								+ '<td>' + patiekalas.patiekalu_produktai[i].kiekis + '</td>';
								
								ingredientai += '<td><input class="trint" type="button" value="Ištrinti"></td>'
								+ '<td><input class="redag" type="button" value="Redaguoti"></td></tr>';
								
								i++;
							}
								
							ingredientai += '</table>';			
										
							$( '#sudetis' ).dialog({   //nusistatom dialogo lango pavadinima
								autoOpen: false,
								title: "Patiekalo: " + patiekalas.pav + " sudėtis:"
							});
									
							$( '#ingredientas' ).html ( ingredientai );
															
							$( ".trint" ).on ( "click", function() {
								
								ingred_id = $( this ).parent().parent().data( 'id' );
								ingred_pav = $( this ).parent().parent().data( 'pav' );
								ConfirmDialog1('Trinti produktą?');
														
							});
							
							$( ".redag" ).on ( "click", function() {
								
								ingred_id = $( this ).parent().parent().data( 'id' );
								ingred_pav = $( this ).parent().parent().data( 'pav' );
								ingred_kiekis = $( this ).parent().parent().data( 'kiekis' );
								editIng(ingred_id);							
							});
						
						});
		}		
			
		$( "#itraukti" ).on( "click", function() { dialog.dialog( "open" );	});
		
		function ConfirmDialog1(message) {
			$('<div></div>').appendTo('body')
			.html('<div><h6>' + message + '?</h6></div>')
			.dialog({
			modal: true,
			title: 'Įspėjimas!',
			zIndex: 10000,
			autoOpen: true,
			width: 'auto',
			resizable: false,
			buttons: {
			Taip: function() {
          
				delIng ( ingred_id, 'istrinti' );
				
				$(this).dialog("close");
				},
			
			Ne: function() {
				
				$(this).dialog("close");
				}
			},
			
			close: function(event, ui) {
			$(this).remove();
			}
			});
		};
	
		function ConfirmDialog(message) {
			$('<div></div>').appendTo('body')
			.html('<div><h6>' + message + '?</h6></div>')
			.dialog({
			modal: true,
			title: 'Įspėjimas!',
			zIndex: 10000,
			autoOpen: true,
			width: 'auto',
			resizable: false,
			buttons: {
			Taip: function() {
          
				del_pat ( id_accessing, 'istrinti' );
				
				$(this).dialog("close");
				},
			
			Ne: function() {
				
				$(this).dialog("close");
				}
			},
			
			close: function(event, ui) {
			$(this).remove();
			}
			});
		};

		function addPat() {
		
			if ( $(pav).val().length == 0 ) {
		
				alert("Pavadinimo laukas tusčias!");
			}
			
			else if 	( $(trukme_ruosimo).val().length == 0 ) {
		
				alert("Trukmė ruošimo laukas tusčias!");
			}	
		 
			else if 	( $(trukme_kaitinimo).val().length == 0 ) {
		
				alert("Trukmė kaitinimo laukas tusčias!");
			}
		
			else if 	( $(kaina).val().length == 0 ) {
		
				alert("Kaina laukas tusčias!");
			}
		
			else {
			
				itrauktas = {
				pav: $( '#pav' ).val()
				, trukme_ruosimo: $( '#trukme_ruosimo' ).val() 
				, trukme_kaitinimo: parseInt ( $( '#trukme_kaitinimo' ).val() )
				, kaina: parseFloat ( $( '#kaina' ).val() )
				}
			
				params_str = 
				"pav="  + itrauktas.pav 
				+ '&trukme_ruosimo=' + itrauktas.trukme_ruosimo 
				+ '&trukme_kaitinimo=' + itrauktas.trukme_kaitinimo
				+ '&kaina=' + itrauktas.kaina
							
				$.ajax(
				{
					url: "http://localhost:8080/restfull/add_pat?" + params_str
				})
					
				.done( function( data ) {
				
					pasiimtiPatiekalus();
			
				});	
		
				dialog.dialog( "close" );	
			}
		}
	
		function addIng() {
						
						$( this ).each ( function() {
								
							id_add_pat = $( this ).parent( ).parent().data ( 'id' );
							
							$.ajax(
								{
									url: "http://localhost:8080/restfull/produktai" 
															
								})
			
							.done(	function( data ) {
							
								for ( i = 0; i < data.length; i++) {
	
									$( 'select#dropdown' ).append(  '<option value="' + data [ i ].id + '">' + data [ i ].pav + '</option>');
								}
								
							});
							
						$( "#sudetis" ).dialog("close");
						
						dialog1.dialog( "open" );
								
						});
					}
					
		function delIng(id)	{
			
			params_str = 'id=' + ingred_id;  
		
			$.ajax(
				{
					url: "http://localhost:8080/restfull/deling?" + params_str
				}
			)
			.done( function( data ) {
				
				pat_sudetis();
			});
			
		}
		
		function editIng(id)	{
			
			alert(ingred_kiekis);
			
		}
					
		function addIng_confirm() {
			
			itrauktas = {	
				
				idp: parseInt ( $( '#dropdown' ).val() ) 
				, kiekisp: parseInt ( $( '#kiekisp' ).val() ) 
					
				}

			params_str = 
					"patiekalo_id=" + patiekalo_id
					+ '&produkto_id='  + itrauktas.idp 
					+ '&kiekis=' + itrauktas.kiekisp 
					
									
			$.ajax(
				{
					url: "http://localhost:8080/restfull/adding?" + params_str
				}
			)
			.done( function( data ) {
				
				dialog1.dialog("close");
				pat_sudetis();
				
				
			});
					$( "#sudetis" ).dialog("open");
		}
			
		dialog = $( "#dialog-form" ).dialog({
	
			autoOpen: false,
			height: 450,
			width: 350,
			modal: true,
			buttons: {
			"Įtraukti patiekalą": addPat,
			Uždaryti: function() {
			dialog.dialog( "close" );
			}
			},
		});
		
			
		dialog1 = $( "#dialog-form1" ).dialog({
		autoOpen: false,
		height: 300,
		width: 380,
		modal: true,
		
		buttons: {
        "Įtraukti ingredientą": addIng_confirm,
        Uždaryti: function() {
         dialog1.dialog( "close" );
        }
		},
		});	
		
		$( "#sudetis" ).dialog({
		
			autoOpen: false,
			height: 300,
			width: 440,
			show: {
			effect: "blind",
			duration: 300
			},
			hide: {
			effect: "explode",
			duration: 300
			},
			buttons: {
			"Pridėti": addIng,
			Uždaryti: function() {
			$( "#sudetis" ).dialog( "close" );
			}
			},
		});
			
	});
		
	$( function() {
    $( document ).tooltip();
	});
	
	
