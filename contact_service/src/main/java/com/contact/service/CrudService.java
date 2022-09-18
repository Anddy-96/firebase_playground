package com.contact.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.contact.entity.Crud;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class CrudService
{

	public String createCrud(Crud crud) throws ExecutionException, InterruptedException
	{
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectiosApiFuture = firestore.collection("crud_firebase").document(crud.getDocumentId()).set(crud);
		return collectiosApiFuture.get().getUpdateTime().toString();
	}

	public Crud getCrud(String documentId) throws ExecutionException, InterruptedException
	{
		Firestore firestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = firestore.collection("crud_firebase").document(documentId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		Crud crud;
		if(document.exists())
		{
			crud = document.toObject(Crud.class);
			return crud;
		}
		return null;
	}

	public String updateCrud(Crud crud) throws ExecutionException, InterruptedException
	{
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectiosApiFuture = firestore.collection("crud_firebase").document(crud.getDocumentId()).set(crud);
		return collectiosApiFuture.get().getUpdateTime().toString();
	}

	public String deleteCrud(String documentId)
	{
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = firestore.collection("crud_firebase").document(documentId).delete();
		return "Successfully deleted: "+documentId;
	}
}
