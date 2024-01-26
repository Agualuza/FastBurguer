package com.br.fastBurguer.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fastBurguer.adapters.presenters.webhookPayments.SendPaymentApproveRequest;
import com.br.fastBurguer.application.useCases.EditOrderPaymentStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/paymentWebhook")
@Tag(name = "Payments Webhook", description = "Send Payment approve request")
public class PaymentWebhookController {

        private final EditOrderPaymentStatus editOrderPaymentStatus;

        public PaymentWebhookController(EditOrderPaymentStatus editOrderPaymentStatus) {
                this.editOrderPaymentStatus = editOrderPaymentStatus;
        }

        @Operation(summary = "Post Payment approve")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Webhook Request", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = SendPaymentApproveRequest.class))
                        }),
                        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                                        @Content
                        })
        })
        @PostMapping()
        public ResponseEntity<String> sendPaymentApprove(
                        @RequestBody SendPaymentApproveRequest sendPaymentApproveRequest) {
                try {
                        editOrderPaymentStatus.editOrderPaymentStatus(sendPaymentApproveRequest);
                } catch (Exception e) {
                        return ResponseEntity.badRequest().build();
                }
                return ResponseEntity.ok("Payment Request Receive");
        }

}
