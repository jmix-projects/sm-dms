package com.company.smdms.view.document;

import com.company.smdms.entity.Document;
import com.company.smdms.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "documents/:id", layout = MainView.class)
@ViewController("Document.detail")
@ViewDescriptor("document-detail-view.xml")
@EditedEntityContainer("documentDc")
public class DocumentDetailView extends StandardDetailView<Document> {
}