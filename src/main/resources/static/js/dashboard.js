$(document).ready(function() {
	var table = $('table#user-table').DataTable({
		'ajax' : '/data-table/users',
		'serverSide' : true,
		columns : [ {
			data : 'firstName',
			render : function(data, type, row) {
                if (row.firstName) {
                    return row.firstName;
                }
                return '';
            }
		}, {
			data : 'lastName',
            render : function(data, type, row) {
                if (row.lastName) {
                    return row.lastName;
                }
                return '';
            }
		}, {
			data : 'cmedId',
            render : function(data, type, row) {
                if (row.cmedId) {
                    return row.cmedId;
                }
                return '';
            }
		}, {
			data : 'birthDay'
		}, {
			// add another column not persisted on the server-side
			data : 'anothercolumn',
			// order is not available
			orderable : false,
			// yet filter should be available through the method
			// findAll(DataTablesInput input, Specification<T>
			// additionalSpecification)
			searchable : false
		/*	render : function(data, type, row) {
				if (row.firstName && row.lastName) {
					return row.firstName + ' and ' + row.lastName;
				}
				return '';
			}*/
		} ]
	});

	/*$('select#role_selector').change(function() {
		var filter = '';
		$('select#role_selector option:selected').each(function() {
			filter += $(this).text() + "+";
		});
		filter = filter.substring(0, filter.length - 1);
		table.columns(2).search(filter).draw();
	});

	$('select#status_selector').change(function() {
		var filter = '';
		$('select#status_selector option:selected').each(function() {
			filter += $(this).text() + "+";
		});
		filter = filter.substring(0, filter.length - 1);
		table.columns(3).search(filter).draw();
	});*/
});