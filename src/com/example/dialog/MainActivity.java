package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	CharSequence[] items={"Google","Apple","Ms"};
	boolean[] itemCheck=new boolean[items.length];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		
		switch (id) {
		case 0:
			
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("This is a dialog with some simple text ..")
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(),
							"Ok Clicked",Toast.LENGTH_SHORT).show();
				}
			}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(),
							"Cancel Clicked",Toast.LENGTH_SHORT).show();
				}
			})
			.setMultiChoiceItems(items, itemCheck,new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					// TODO Auto-generated method stub
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(),
							items[which]+  (isChecked ? "Check":"UnCheck"),Toast.LENGTH_SHORT).show();
				}
			}).create();
			

		default:
			break;
		}
		return super.onCreateDialog(id);
	}
	@SuppressWarnings("deprecation")
	public void onClick_displayDialog(View view){
		
		showDialog(0);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void onClick_ShowDetailProgress(View view) {
		
		
		final ProgressDialog _proProgressDialog=new ProgressDialog(MainActivity.this);
		_proProgressDialog.setTitle("文件下载中");
		_proProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		_proProgressDialog.setButton(DialogInterface.BUTTON_POSITIVE,
				"Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		_proProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
				"Cancle", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		_proProgressDialog.show();
		_proProgressDialog.setProgress(0);
		_proProgressDialog.setMax(100);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
				for (int i = 0; i < 10; i++) {
					
					
					_proProgressDialog.setProgress(10*(i+1));
					Thread.sleep(200);
						
					
				}} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				_proProgressDialog.dismiss();
			}
		}).start();
	}
	public void onClick_ShowProcess(View view) {
		
		 final ProgressDialog _pProgressDialog=ProgressDialog.show(MainActivity.this, "请等待", "数据加载中",true);
		/*_pProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		//_pProgressDialog.setIcon(R.drawable.icon);  
		
		_pProgressDialog.setMax(100);  
		_pProgressDialog.setProgress(0);  
		_pProgressDialog.setSecondaryProgress(50);  
		_pProgressDialog.setIndeterminate(false);  
		_pProgressDialog.show();*/
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					
					Thread.sleep(3000);
					_pProgressDialog.dismiss();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
		
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
